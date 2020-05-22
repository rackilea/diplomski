public final class Foo {

    // Same signature as an IntComsumer...
    private static void handleCodePoint(final int codePoint)
    {
        if (Character.UnicodeBlock.of(codePoint).equals(Character.UnicodeBlock.EMOTICONS)) {
            // treat as an emoticon
        } else {
            // treat as non emoticon
        }
    }

    // ...

    public void doDisplay(final String input)
    {
        // ... therefore usable in an IntStream's .forEach()
        input.codePoints().forEach(Foo::handleCodePoint);
    }
}