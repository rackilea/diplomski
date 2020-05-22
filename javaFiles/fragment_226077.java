interface Saveable
{
    boolean canSave();
}

public class Cow implements Saveable
{
    //...

    @Override
    boolean canSave()
    {
        return getName() != null && !getName().isEmpty();
    }
}

public class Animal<T extends Saveable> implements MyInterface<T>
{
    @Override
    public void save(T obj)
    {
        if (obj.canSave())
        {
            //whatever
        }
    }
}