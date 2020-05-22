class SomeGui extends Dialog {
    TreeViewer someWidget;
    ISelectionChangedListener someListener;

    private void someMethod() {
        someListener = new SelectionChangedListener();
        someWidget.addSelectionChangedListener(someListener);
    }

    void doSomething() {
    }

    private class SelectionChangedListener implements ISelectionChangedListener {
        @Override
        public void selectionChanged(SelectionChangedEvent event) {
           doSomething();
        }
    }
}