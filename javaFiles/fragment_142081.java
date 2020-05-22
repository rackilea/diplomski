public abstract class AbstractClient<T> {
    public abstract List<T> listEntities();
}

public class ConcreteClient extends AbstractClient<Entity> {
    @Override
    public List<Entity> listEntities();
}

public class ConcreteClient2 extends AbstractClient<String> {
    @Override
    public List<String> listEntities();
}