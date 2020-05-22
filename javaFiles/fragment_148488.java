public abstract class Base
{
    public abstract Object save();
    public abstract void load(Object x);
}

public class Derived extends Base
{
    @Override
    public String save() { ... } // Valid

    @Override
    public void load(String x) // Not valid
}