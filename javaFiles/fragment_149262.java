IStructuredSelection sel = treeViewer.getStructuredSelection();

Object selected = sel.getFirstElement();

((MyData)selected).setText(text.getText());

treeViewer.update(selected, null);