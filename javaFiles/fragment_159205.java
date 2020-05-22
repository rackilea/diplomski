public final class EnumStateResolver implements StateResolver {

    private final Set<? extends State> states;
    private final Map<String, State> shortNameSearch;
    private final Map<String, State> longNameSearch;

    {
        states = Collections.unmodifiableSet(EnumSet.allOf(StateData.class));
        shortNameSearch = new HashMap<>();
        longNameSearch = new HashMap<>();
        for (final State state : StateData.values()) {
            shortNameSearch.put(state.shortName(), state);
            longNameSearch.put(state.fullName(), state);
        }
    }

    @Override
    public State fromFullName(final String fullName) {
        final State s = longNameSearch.get(fullName);
        if (s == null) {
            throw new IllegalArgumentException("Invalid state full name " + fullName);
        }
        return s;
    }

    @Override
    public State fromShortName(final String shortName) {
        final State s = shortNameSearch.get(shortName);
        if (s == null) {
            throw new IllegalArgumentException("Invalid state short name " + shortName);
        }
        return s;
    }

    @Override
    public Set<? extends State> getAllStates() {
        return states;
    }

}