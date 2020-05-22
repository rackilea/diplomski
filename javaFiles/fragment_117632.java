public static SessionState convert(SessionStateCopy s) {
    return SessionState.valueOf(s.name());
}

public static SessionStateCopy convert(SessionState s) {
    return SessionStateCopy .valueOf(s.name());
}