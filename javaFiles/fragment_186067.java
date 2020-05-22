import java.util.Observable;

public class DataModel extends Observable
{
    public void retrieveData()
    {
        // ...

        setChanged();
        notifyObservers(); // or notifyObservers(someData);
    }
}