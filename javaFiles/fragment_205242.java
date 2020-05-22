public class Master {
    static {
        SlaveClass1.init();
        SlaveClass2.init(SlaveClass1.someInitializedValue);
        // etc.
    }
}