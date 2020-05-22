public final class Factorial
{
    public static Trampoline<Integer> createTrampoline(final int n, final int sum)
    {
        if (n == 1) {
            return new Trampoline<Integer>() {
                public Integer getValue() { return sum; }
            };
        }

        return new Trampoline<Integer>() {
            public Optional<Trampoline<Integer>> nextTrampoline() {
                return Optional.of(createTrampoline(n - 1, sum * n));
            }
        };
    }
}