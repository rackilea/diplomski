public interface Interface<T> extends Immutable<T> {

    public interface BuilderInterface<T> extends Immutable.Builder<T> {
    }
}


public abstract class AbstractClass<T> implements Interface<T> {

    public static class AbstractBuilder<T> implements Interface.BuilderInterface<T> {

        private final T object;

        public AbstractBuilder(T object) {

            this.object = object;
        }

        @Override
        public T build() {

            return this.object;
        }
    }

    protected AbstractClass() {

        super();
    }
}


public class ConcreteClass extends AbstractClass<ConcreteClass> {

    public ConcreteClass() {

    }

    @Override
    public Builder<ConcreteClass> builder() {
        return new AbstractClass.AbstractBuilder<ConcreteClass>(this);
    }
}