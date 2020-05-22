private List<Coordinates> myCoordinates = Collections.synchronizedList( new ArrayList<>());

public void addCoordinates( Coordinates coordinates)
{ 
    // this runs in the context of your GUI thread
    myCoordinates.add(coordinates);
    synchronized(this)
    {
        this.notify();    // wakes up the recorder thread
    }

}

public void run()
{
    // this runs in the context of the Recorder thread
    while ( true)
    {
        synchronized(this)
        {
            this.wait();   // waits until the 'this' is notified
        }

        for( Coordinates c : myCoordinates)
        {
            // do something
        }
    }
}