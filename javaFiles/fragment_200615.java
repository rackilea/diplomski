public class Example {
    public List<Function<Boolean, Integer>> getFunctions(boolean t) {
        return Arrays.asList(
            this::magicNumber
        );
    }

    public int magicNumber(boolean t) {
        return (t) ? new Random().nextInt(11) : 0;
    }
}