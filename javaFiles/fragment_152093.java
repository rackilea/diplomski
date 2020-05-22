abstract class Bar {

    public final void foo() {
        // add the base code for your method here
        // ...
        this.additionalWork();
    }

    // part that has to be overwritten
    public abstract void additionalWork();

}