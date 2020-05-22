public boolean openRead() throws FileNotFoundException
    {
        boolean result = super.openRead(); // we are calling the parent's openRead() method to set up the Scanner sc object
        Scanner sc = getScanner();
        sc.useDelimiter(DELIMITERS);
        return result;
    }