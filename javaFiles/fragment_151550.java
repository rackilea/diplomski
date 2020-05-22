class ConcreteTypeMatcher<T extends Component> extends GenericTypeMatcher<T> {
    Class<T> type;

    public ConcreteTypeMatcher(Class<T> supportedType) {
        super(supportedType);
        this.type = supportedType;
    }

    @Override
    protected boolean isMatching(T arg) {
        return type.isInstance(arg);
    }
}