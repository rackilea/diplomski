public class AnotherClassRed extends AnotherClass {
    @Override
    public AnotherClass format() {
        return new AnotherClassBlack();
    }
}

public class AnotherClassBlack extends AnotherClass {
    // Note: This is *not* a subclass of AnotherClassRed
    ...