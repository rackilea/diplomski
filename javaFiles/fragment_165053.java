public class ResultEntry<R> {

    private final ResultType mType;
    private final String mLabel;
    private final Object mInfo;

    private ResultEntry(final ResultType t, final String label, final Object info) {
        this.mType = t;
        this.mLabel = label;
        this.mInfo = info;
    }

    public static ResultEntry<Number> newInstance(final String label, final Number info) {
        return new ResultEntry<>(ResultType.NUMBER, label, info);
    }

    public static ResultEntry<Boolean> newInstance(final String label, final Boolean info) {
        return new ResultEntry<>(ResultType.BOOLEAN, label, info);
    }

    public static ResultEntry<String> newInstance(final String label, final String info) {
        return new ResultEntry<>(ResultType.STRING, label, info);
    }

    public final ResultType getType() {
        return this.mType;
    }

    public final String getLabel() {
        return this.mLabel;
    }

    @SuppressWarnings("unchecked")
    public final R getInfo() {
        return (R) this.mInfo;
    }

}