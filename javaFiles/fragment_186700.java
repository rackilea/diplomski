public interface NumberStep {
    NumberStep withNumber(int number);
}
public interface NeitherDoneStep extends NumberStep {
    @Override NeitherDoneStep withNumber(int number);
    <T> TypeDoneStep<T> withTyped(T type);
    <S> ListDoneStep<S> withList(List<S> list);
}
public interface TypeDoneStep<T> extends NumberStep {
    @Override TypeDoneStep<T> withNumber(int number);
    TypeDoneStep<T> withTyped(T type);
    <S> BothDoneStep<T, S> withList(List<S> list);
}
public interface ListDoneStep<S> extends NumberStep {
    @Override ListDoneStep<S> withNumber(int number);
    <T> BothDoneStep<T, S> withTyped(T type);
    ListDoneStep<S> withList(List<S> list);
}
public interface BothDoneStep<T, S> extends NumberStep {
    @Override BothDoneStep<T, S> withNumber(int number);
    BothDoneStep<T, S> withTyped(T type);
    BothDoneStep<T, S> withList(List<S> list);
    SomeObject<T, S> create();
}
@SuppressWarnings({"rawtypes","unchecked"})
private static final class BuilderImpl implements NeitherDoneStep, TypeDoneStep, ListDoneStep, BothDoneStep {
    private final int number;
    private final Object typed;
    private final List list;

    private BuilderImpl(int number, Object typed, List list) {
        this.number = number;
        this.typed  = typed;
        this.list   = list;
    }

    @Override
    public BuilderImpl withNumber(int number) {
        return new BuilderImpl(number, this.typed, this.list);
    }

    @Override
    public BuilderImpl withTyped(Object typed) {
        // we could return 'this' at the risk of heap pollution
        return new BuilderImpl(this.number, typed, this.list);
    }

    @Override
    public BuilderImpl withList(List list) {
        // we could return 'this' at the risk of heap pollution
        return new BuilderImpl(this.number, this.typed, list);
    }

    @Override
    public SomeObject create() {
        return new SomeObject(number, typed, list);
    }
}

// static factory
public static NeitherDoneStep builder() {
    return new BuilderImpl(0, null, null);
}