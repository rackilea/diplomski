abstract class Tool
{
    // snip...
    public abstract Tool copy();
    // snip...
}

class Hammer
{
    // snip...
    public Tool copy()
    {
        Hammer h = new Hammer();
        // copy fields from this to h
        return h;
    }
    // snip...
}