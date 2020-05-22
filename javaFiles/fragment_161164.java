@SuperBuilder
public abstract class Base {
    public static abstract class BaseBuilder<C extends Base, B extends BaseBuilder<C, B>> {
        public B fillFromProvider(BValuesProvider bv) {
            b1(bv.b1());
            b2(bv.b2());
            ...
            return self();
        }
    }
    ...
}