public interface TheInterface {
    Object getTheObject();
}

public abstract class TheAbstractClass implements TheInterface {
    @Override
    public abstract String getTheObject();
}