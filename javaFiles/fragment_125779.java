Comparator<Action> COMPARATOR1 =
        comparing(Action::date, nullsLast(naturalOrder()))
        .thenComparing(Action::time, nullsLast(naturalOrder()))
        .thenComparing(Action::foo, nullsLast(naturalOrder()))
        .thenComparing(Action::bar, nullsLast(naturalOrder()))
        .thenComparing(Action::baz, nullsLast(naturalOrder()));