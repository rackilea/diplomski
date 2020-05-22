public class WatchDir {

    private Consumer<Path> onCreate ;

    public void setOnCreate(Consumer<Path> onCreate) {
        this.onCreate = onCreate ;
    }

    // other callbacks as needed...

    // ...

    void processEvents() {

        // ...

        Path child = ... ; // file/folder that was created

        if (! recursive && kind == ENTRY_CREATE) {
            if (onCreate != null) {
                onCreate.accept(child);
            }
        }

        // ...
    }

    // ...
}