public interface ValidateValue<O> extends Copyable
{
     // Other functions...

     @Override
     Copyable getObjectCopy();
}

public Blammy implements ValidateValue<String>
{
    // Other functions...

     @Override
    public Copyable getObjectCopy()
    {
        SomethingThatExtendsCopyable blammy = new SomethingThatExtendsCopyable();

        return (Copyable)blammy;
    }
}