public Mode getMode()
{
    String type = getProperty("mode"); // Now equals "Run" in our example.

    switch(type)
    {
       case "Run": return new RunMode();
       case "Halt": return new HaltMode();  
    }
}