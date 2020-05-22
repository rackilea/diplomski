public static class OneBuilder<T, S, TCAP, SCAP> {
    private final int number;
    private final T typed;
    private final List<S> list;

    private OneBuilder(int number, T typed, List<S> list) {
        this.number = number;
        this.typed  = typed;
        this.list   = list;
    }

    public OneBuilder<T, S, TCAP, SCAP> withNumber(int number) {
        return new OneBuilder<T, S, TCAP, SCAP>(number, this.typed, this.list);
    }

    public <TR extends TCAP> OneBuilder<TR, S, ?, SCAP> withTyped(TR typed) {
        // we could return 'this' at the risk of heap pollution
        return new OneBuilder<TR, S, TCAP, SCAP>(this.number, typed, this.list);
    }

    public <SR extends SCAP> OneBuilder<T, SR, TCAP, ?> withList(List<SR> list) {
        // we could return 'this' at the risk of heap pollution
        return new OneBuilder<T, SR, TCAP, SCAP>(this.number, this.typed, list);
    }

    public SomeObject<T, S> create() {
        return new SomeObject<T, S>(number, typed, list);
    }
}

// Same thing as the previous example,
// we could return <?, ?, Object, Object> if we wanted
// to restrict the return type of create() in the case
// that someone called it immediately.
// (The type arguments to TCAP and SCAP should stay
// Object because they are the initial bound of TR and SR.)
public static OneBuilder<Object, Object, Object, Object> builder() {
    return new OneBuilder<Object, Object, Object, Object>(0, null, null);
}