public abstract class AbstractSon {
    protected void prepare(AbstractSon toPrepare) {
        toPrepare.name = "default name";
    }
}
public class Son1 extends AbstractSon {
    public Son1 createNew() {
        Son1 res = new Son1();
        prepare(res);
        return res;
    }
}
public class Son2 extends AbstractSon {
    public Son2 createNew() {
        Son2 res = new Son2();
        prepare(res);
        return res;
    }
}