public abstract Stuff
{
    public void doStuff() 
    {
      // Do the common stuff initially...
      // ...

      // Then call the subclass implementation
      doRealStuff();
    }

    public abstract void doRealStuff();
}