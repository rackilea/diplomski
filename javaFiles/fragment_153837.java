public class Test {

    private class MyContentProvider implements IStructuredContentProvider {

        @Override
        public Object[] getElements(Object inputElement) {
            return ((List) inputElement).toArray(new MyModel[0]);
        }

        @Override
        public void dispose() {
        }

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

    }

    public class MyModel {
        public String counter;

        public MyModel(String counter) {
            this.counter = counter;
        }

        @Override
        public String toString() {
            return "Item " + counter;
        }
    }

    public Test(Shell shell) {
        // final TableViewer v = new TableViewer(shell);
        Composite c = new Composite(shell, SWT.NONE);
        GridLayoutFactory.swtDefaults().applyTo(c);
        GridDataFactory.defaultsFor(c).hint(100, 100).applyTo(c);

        final ListViewer v = new ListViewer(c);
        // v.setSize(200, 300);
        v.setLabelProvider(new LabelProvider());
        // for demonstration purposes use custom content provider
        // alternatively you could use ArrayContentProvider.getInstance()
        v.setContentProvider(new MyContentProvider());
        v.setComparator(new ViewerComparator());
        v.setInput(createModel());

        GridDataFactory.defaultsFor(v.getControl()).align(SWT.BEGINNING, SWT.TOP).hint(100, 100).grab(true, true)
            .applyTo(v.getControl());
        // v.getTable().setLinesVisible(true);

        Button b = new Button(c, SWT.NONE);
        b.setText("button");
        b.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                int nextInt = RandomUtils.nextInt(100);
                String s = "";
                for (int i = 0; i < nextInt; i++) {
                    s += "" + i;
                }
                // v.add(new MyModel(s));
                ((List) v.getInput()).add(new MyModel(s));
                v.refresh();
                v.getControl().computeSize(SWT.DEFAULT, SWT.DEFAULT);
                v.getControl().pack();
            }
        });
    }

    private List<MyModel> createModel() {
        List<MyModel> elements = new ArrayList<Test.MyModel>();

        for (int i = 0; i < 10; i++) {
            elements.add(new MyModel("" + i));
        }

        return elements;
    }

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        new Test(shell);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();

    }

}