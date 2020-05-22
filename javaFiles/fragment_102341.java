File inFile = new File(inFileName);
    try
    {
        file = new Scanner(inFileName);  
        // you are trying to use the Scanner using a `String`
        // this does not throw an Exception, hence the compile error
        // I think you want to use
        // public Scanner(File source) which throws a FileNotFoundException
        // so change to use instead
        file = new Scanner(inFile);  
    }
    catch(FileNotFoundException e)
    {
        System.err.println("ERROR. Could not read/find file.");
        System.exit(1);
    }