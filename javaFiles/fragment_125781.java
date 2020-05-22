Comparator<Action> COMPARATOR2 =
        comparing(Action::date, nlno())
        .thenComparing(Action::time, nlno())
        .thenComparing(Action::foo, nlno())
        .thenComparing(Action::bar, nlno())
        .thenComparing(Action::baz, nlno());