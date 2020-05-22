public abstract class AbstractSon {
    protected abstract AbstractSon createNewImpl();
    public AbstractSon createNew() {
        AbstractSon res = createNewImpl();
        res.name = "default name";
        return res;
    }
}
public class Son1 extends AbstractSon {
    protected AbstractSon createNewImpl() {
        return new Son1();
    }
}
public class Son2 extends AbstractSon {
    protected AbstractSon createNewImpl() {
        return new Son2();
    }
}