public class ContainerViewEntity<T> {

    private final T object;
    private final Class<? extends BaseView> view;

    public ContainerViewEntity(T object, Class<? extends BaseView> view) {
        this.object = object;
        this.view = view;
    }

    public T getObject() {
        return object;
    }

    public Class<? extends BaseView> getView() {
        return view;
    }

    public boolean hasView() {
        return this.getView() != null;
    }
}