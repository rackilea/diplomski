public abstract class AbstractWriter<T extends BE> {
    //...
    public static interface Setter<S> {
        void setNewValue(S newValue);
    }

    protected <S> void setValue(final Class<S> clazz, final S oldValue,
        final S newValue, final Setter<S> setter) {
        // Do something
        setter.setNewValue(newValue);
        // Do something
    }    
}