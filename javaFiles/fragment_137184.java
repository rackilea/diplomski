DummyClass dummyInstance = new DummyClass(new ImplementationProvider());

///////

public interface Implementable{[...]}
public class Implementation implements Implementable{[...]}

public interface ImplementationProviderAware
{
    public Implementable createImplementation(Integer counter);
}

public class ImplementationProvider implements ImplementationProviderAware
{
    public Implementable createImplementation(Integer counter)
    {
        return new Implementation(counter);
    }
}

public class DummyClass(ImplementationProviderAware implementationProvider)
{
    private List<Implementable> testList;
    public DummyClass()
    {
        testList = new ArrayList<Implementable>();
        for(int i = 0; i < 10; i++)
        {
            Implementable testVar = implementationProvider.createImplementation(i);
            testList.add(testVar);
        }
    }
}