public abstract class Command<T> {
    private final Class<T> argumentClass;

    protected Command(Class<T> argumentClass) {
        this.argumentClass = argumentClass;
    }

    public abstract <U extends T> void execute(U argument);


    @SuppressWarnings("unchecked")
    public final <U> Command<? super U> cast(Class<U> argumentClass) {
        if (this.argumentClass.isAssignableFrom(argumentClass)) {
           return (Command<? super U>) this;
        } else {
           throw new UnsupportedOperationException("this command cannot handle argument of type " + argumentClass.getName());
        }
    }
}