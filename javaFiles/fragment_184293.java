public class ScannerUserParent
{
    protected Scanner sc;
    private String filename = null;

    // all that other stuff like constructors...

    public boolean openRead() throws FileNotFoundException
    {
        sc = new Scanner(new File(fileName));

        if (fileName != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}