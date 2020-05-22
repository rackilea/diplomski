@FunctionalInterface
interface Function<One, Two, Three, Four, Five, Six> {
    public Six apply(One one, Two two, Three three, Four four, Five five);
}

public static void main(String[] args) throws Exception {
    Function<String, Integer, Double, Void, List<Float>, Character> func = (a, b, c, d, e) -> 'z';
}