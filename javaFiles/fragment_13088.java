@MappedSuperclass
public abstract class MyDefaultProperty<T> extends MyAbstractProperty<T extends Object> {

    @Column(name="defaultValue")
    protected T defaultValue;

    @Override
    public T getDefaultValue() {
        return defaultValue;
    }
}