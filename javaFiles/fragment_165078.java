class SomeGui extends Dialog {
    TreeViewer someWidget;
    ISelectionChangedListener someListener;

    private void someMethod() {
        someListener = this::widgetSelectionChanged;
        someWidget.addSelectionChangedListener(someListener);
    }

    private void doSomething() {
    }

    private void widgetSelectionChanged(SelectionChangedEvent event) {
       doSomething();
    }