public class DoubleDecoratorCount extends DecoratorCount {

    public DecoratorCount(PrintNumbers pn)
    {
        super(pn);
    }

    public int getNextNumber()
    {    
        return pn.getNextNumber() * 2;
    }
}