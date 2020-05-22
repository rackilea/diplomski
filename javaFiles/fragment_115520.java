public class Example {
    IFooBean fooBean;
    IBarBean barBean;
    String name;

    public Example(IFooBean fooBean, IBarBean barBean, String name) {
        System.out.printf("%s(fooBean=%s, barBean=%s, name=%s)\n", this, fooBean, barBean, name);
        this.fooBean = fooBean;
        this.barBean = barBean;
        this.name = name;
    }
}