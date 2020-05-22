@Override public boolean isCellEditable(EventObject e) {
    Object source = e.getSource();
    if (!(source instanceof JTree) || !(e instanceof MouseEvent)) {
      return false;
    }
    JTree tree = (JTree) source;
    Point p = ((MouseEvent) e).getPoint();
    Object node = tree.getPathForLocation(p.x, p.y).getLastPathComponent();
    if (!(node instanceof DefaultMutableTreeNode)) {
      return false;
    }
    Object userObject = ((DefaultMutableTreeNode) node).getUserObject();
    if (!(userObject instanceof Book)) {
      return false;
    }
    return super.isCellEditable(e);
  }

  @Override
  public Object getCellEditorValue() {
    return new Book(renderer.nomeRadar.getText());
  }