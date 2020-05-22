// Our class variables
private int attempts = 0, limit = 3;

// A method to call our recursive method for the first time.
void BeginProcessing()
{
     ProcessData();
}

// Our recursive method containing our read logic.
void ProcessData()
{
    try
    {
        /* Insert read logic here. */
    }
    catch(Exception)
    {
        attempts++;

        if (attempts<=limit)
        {
            ProcessData();
        }
        else
        {
            System.out.println("Attempted to process " + limit + " times.");        
        }
    }
}