static boolean empty = false;

public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    TreeViewer treeViewer = new TreeViewer(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
    treeViewer.setContentProvider(new DummyContentProvider());
    treeViewer.setAutoExpandLevel(3);
    treeViewer.setInput("root");

    empty = true;
    treeViewer.refresh();

    shell.setSize(200, 200);
    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}

private static class DummyContentProvider implements ITreeContentProvider {

    @Override
    public Object[] getElements(Object inputElement) {
        return this.getChildren(inputElement);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        if (!empty) {
            return new Object[0];
        }
        switch ((String) parentElement) {
            case "root":
                return new String[]{"a", "b"};
            case "a":
                return new String[]{"1"};
            case "b":
                return new Object[]{"1", "2"};
            case "1":
                return new Object[]{"x", "y"};
            default:
                return new String[0];
        }
    }

    @Override
    public Object getParent(Object element) {
        return null;
    }

    @Override
    public boolean hasChildren(Object element) {
        return this.getChildren(element).length > 0;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
}