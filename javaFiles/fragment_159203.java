public interface State {

    String fullName();

    String shortName();
}

public interface StateResolver {

    State fromFullName(final String fullName);

    State fromShortName(final String shortName);

    Set<? extends State> getAllStates();
}