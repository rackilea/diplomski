class MainClass {

    protected final void innerDoIt () { //final: so no @Override
        ...
        else innerDoIt();
    }

    public void doIt() {
        innerDoIt();
    }

}