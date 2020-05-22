interface Viewable<V extends Viewable<V, N>, N extends Node & View<V, N>> {
    N view();
}

interface View<V extends Viewable<V, TNode>, TNode extends Node & View<V, TNode>> {
    V getViewable();
}

class ViewableObject implements Viewable<ViewableObject, ViewableObject.ObjectView> {
    @Override
    public ObjectView view() {
        return new ObjectView();
    }

    class ObjectView extends Pane implements View<ViewableObject, ObjectView> {
        @Override
        public ViewableObject getViewable() {
            return ViewableObject.this;
        }
    }
}