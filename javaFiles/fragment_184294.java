public class ScannerUserChild extends ScannerUserParent
{
    protected final String DELIMITERS = "[\\s[^'a-zA-Z]]";

    // stuff like constructors...

    public boolean openRead() throws FileNotFoundException
    {
        boolean result = super.openRead(); // we are calling the parent's openRead() method to set up the Scanner sc object

        sc.useDelimiter(DELIMITERS);
        return result;
    }
}