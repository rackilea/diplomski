public void createPartControl(Composite parent) {
  viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
  viewer.setContentProvider(new ViewContentProvider());
  viewer.setLabelProvider(new ViewLabelProvider());
  viewer.setInput(createDummyModel());

  experiment();
}

private void experiment() {

  // Button experimentation  
  Tree tree = viewer.getTree();
  TreeItem[] items = tree.getItems();

  for(int i = 0; i < items.length; i++){
    TreeEditor editor = new TreeEditor(tree);

    TreeItem item = items[i];

    Button button = new Button(tree, SWT.PUSH);

    button.setText("A");
    button.setSize(16,16);
    button.pack();

    editor.horizontalAlignment = SWT.RIGHT;
    editor.grabHorizontal = true;
    editor.minimumWidth = 50;
    editor.setEditor(button, item);
  }
}