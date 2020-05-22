public class AImpl extends AAbstract {
    private AImpl() {
        Context.set("init");
    }

    public static AImpl create() {
        return new AImpl();
    }
}