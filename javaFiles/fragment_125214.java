public class Foo {

    public static final Bar BAR = initBar(20);

    private static Bar initBar(int value) {
        try {
            return new Bar(20);
        } catch (InvalidCharacterException e) {
            return null;
        }
    }

}