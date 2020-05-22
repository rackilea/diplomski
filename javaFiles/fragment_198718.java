abstract class Base {
    public doActivity() {
        doCommonStuff();
        doSpecificStuff();
        doOtherCommonStuff();
        doOtherSpecificStuff();
    }

    protected abstract void doSpecificStuff();
    protected abstract void doOtherSpecificStuff();

    private final void doCommonStuff() { ... }
    private final void doOtherCommonStuff() { ... }
}