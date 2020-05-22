public static class OneBuilder<T, S> {
    private final int number;
    private final T typed;
    private final List<S> list;

    private OneBuilder(int number, T typed, List<S> list) {
        this.number = number;
        this.typed  = typed;
        this.list   = list;
    }

    public OneBuilder<T, S> withNumber(int number) {
        return new OneBuilder<T, S>(number, this.typed, this.list);
    }

    public <TR> OneBuilder<TR, S> withTyped(TR typed) {
        // we could return 'this' at the risk of heap pollution
        return new OneBuilder<TR, S>(this.number, typed, this.list);
    }

    public <SR> OneBuilder<T, SR> withList(List<SR> list) {
        // we could return 'this' at the risk of heap pollution
        return new OneBuilder<T, SR>(this.number, this.typed, list);
    }

    public SomeObject<T, S> create() {
        return new SomeObject<T, S>(number, typed, list);
    }
}

// As a side note,
// we could return e.g. <?, ?> here if we wanted to restrict
// the return type of create() in the case that somebody
// calls it immediately.
// The type arguments we specify here are just whatever
// we want create() to return before withTyped(...) and
// withList(...) are each called at least once.
public static OneBuilder<Object, Object> builder() {
    return new OneBuilder<Object, Object>(0, null, null);
}