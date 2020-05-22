public class FooDelegateSelector {
    public static boolean selectDelegate1; //true for 1, false for 2

    private Foo delegate1;
    private Foo delegate2;
    //delegates setup...

    public Foo getSelectedDelegate() {
        return selectDelegate1 ? delegate1 : delegate2;
    }
}