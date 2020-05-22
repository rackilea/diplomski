public interface View {
    public JComponent getView();
}

public interface Controller<M, V extends View> {
    public M getModel()
    public V getView();
}