public abstract class Parser<T> {
    private final Class<T> mType;

    protected Parser(final Class<T> type) {
        this.mType = type;
    }

    public final Class<T> getType() {
        return mType;
    }

    @SuppressWarnings("unchecked")
    public final <U> Parser<U> castToParserOf(final Class<U> type) {
        if (type == mType) {
            return (Parser<U>) this;
        } else {
            throw new ClassCastException("... useful message ...");
        }
    }
}