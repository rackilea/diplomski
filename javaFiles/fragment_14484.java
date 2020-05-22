public enum FirstSingletonEnum implements MySingleTonInterface {

    ...

    @Override
    public void doFoo(Bar bar) {
        ... //do something with bar
    }
}

public enum SecondSingletonEnum implements MySingleTonInterface {

    ...

    @Override
    public void doFoo(Bar bar) {
        ... //do something slightly different with Bar
    }
}