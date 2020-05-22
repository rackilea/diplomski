// The interface
public interface NextNumber {

     public int getNextNumber();
}

// The class to decorate
public class PrintNumbers implements NextNumber {

    protected int num;

    public PrintNumbers(int startFrom)
    {
        this.num = startFrom;
    }

    public int getNextNumber()
    {
        return num++;
    }
}

// The abstract decorator
public abstract class DecoratorCount implements NextNumber {

    private PrintNumbers pn;

    public DecoratorCount(PrintNumbers pn)
    {
       this.pn = pn;
    }
}