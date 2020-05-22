public abstract class AbstractPresenter<M extends IModel, V extends IView>
        implements IPresenter<M, V> {

    private final M model;
    private final V view;

    protected AbstractPresenter(final M model, final IViewFactory<V, ? super IPresenter<M, V>> viewFactory) {
        this.model = model;
        view = viewFactory.createView(this);
    }

...

}