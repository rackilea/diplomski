class Tool
{
    // ...

    public Tool () {}

    public int getWeight ()
    {
        // don't care about implementation
    }

    public void setWeight()
    {
        // don't care about implementation
    }

    // ignores all exceptions - not production code!
    public Tool copy() throws Exception
    {
        Tool copy = this.getClass().getConstructor().newInstance();
        copy.setWeight(this.getWeight());
        return copy;
    }

    // ...
}