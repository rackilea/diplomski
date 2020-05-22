/**
 * Static factory methods to create {@link Function}s for {@link User}s.
 */
public final class UserFunctions {
    private UserFunctions() { /* prevents instantiation */ }

    /**
     * @return a {@link Function} that returns an {@link User}'s id.
     */
    public static Function<User, Integer> getId() {
        return GetIdFunction.INSTANCE;
    }

    // enum singleton pattern
    private enum GetIdFunction implements Function<User, Integer> {
        INSTANCE;

        public Integer apply(User user) {
            return user.getId();
        }
    }

}