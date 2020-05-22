public abstract class Blam
{
    private final int itemId;
    private final String name;

    protected(
        final int itemId,
        final String name)
    {
        this.itemId = itemId;
        this.name = name;
    }
}


public class Derived
extends
    Blam
{
    public Derived()
    {
        super(123, "nameValue");
    }
}