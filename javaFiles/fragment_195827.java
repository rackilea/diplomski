public class FooEditor extends Composite implements Editor<Foo> {

    // Implement one of uibinder+fields, fields, methods, or LeafValueEditor.set/getValue()

    public FooEditor() {
        initWidget(/* root widget or call to uiBinder.createAndBindUi(this) */)
    }

}

public class FooListEditor extends Composite implements IsEditor<ListEditor<Foo, FooEditor>> {

    private class FooEditorSource extends EditorSource<FooEditor> {
        @Override
        public FooEditor create(int index) {
            FooEditor subEditor = new FooEditor();

            // any additional per-item config can go here, e.g wiring up delete handler

            listPanel.insert(subEditor, index);

            return subEditor;
        }

        @Override
        public void dispose(FooEditor subEditor) {
            subEditor.removeFromParent();
        }

        @Override
        public void setIndex(FooEditor subEditor, int index) {
            listPanel.insert(subEditor, index);
        }
    }

    // FlowPanel or anything else you want to use to hold the sub-editors.
    // Instantiated explicitly or through uibinder.
    FlowPanel listPanel = new FlowPanel(); 


    // Let GWT handle the ListEdiotr implementation
    ListEditor<Foo, FooEditor> editor = ListEditor.of(new FooEditorSource());

    public FooListEditor() {
        initWidget(listPanel /* or uiBinder.createAndBindUi(this) */);
    }

    @Override
    public ListEditor<Foo, FooEditor> asEditor() {
        return editor;
    }

}