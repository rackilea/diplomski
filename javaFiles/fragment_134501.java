public abstract class Base {
    protected abstract void m();
}

public interface Interface {
    public void m();
}

public class Class<T extends Base & Interface> {} // not ok