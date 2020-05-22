abstract class AbstractFancy implements Fancy {
    abstract Fancy create();

    void my() {
        Fancy b = create();
        //....
    }
}