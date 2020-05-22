JTree tree = new JTree();
tree.setDragEnabled(true);
tree.setDropMode(DropMode.ON_OR_INSERT);
tree.setTransferHandler(new YourTreeTransferHandler());
//......
Object key = TransferHandler.getCutAction().getValue(Action.NAME);
System.out.println(key);
tree.getActionMap().put(key, new AbstractAction() {
  @Override public void actionPerformed(ActionEvent e) {
    System.out.println("dummy");
  }
});