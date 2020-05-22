import java.util.Scanner;

public class PeekableScanner
{
    private Scanner scan1;
    private Scanner scan2;
    private String next;

    public PeekableScanner( String source )
    {
        scan1 = new Scanner(source);
        scan2 = new Scanner(source);
        next = scan2.next();
    }

    public boolean hasNext()
    {
        return scan1.hasNext();
    }

    public String next()
    {
        next = (scan2.hasNext() ? scan2.next() : null);
        return scan1.next();
    }

    public String peek()
    {
        return next;
    }
}