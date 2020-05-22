public final class NoSyntheticMethodMatcher extends AbstractMatcher<Method> {
    public static final NoSyntheticMethodMatcher INSTANCE = new NoSyntheticMethodMatcher();
    private NoSyntheticMethodMatcher() {}

    @Override
    public boolean matches(Method method) {
        return !method.isSynthetic();
    }
}