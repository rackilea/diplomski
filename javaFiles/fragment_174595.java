private void toggleCheckBox(TreePath treePath)
  {
    // Determine node being toggled
    Object[]               path;
    DefaultMutableTreeNode node;
    NodeInfo               info;
    path = treePath.getPath();
    node = (DefaultMutableTreeNode)path[path.length - 1];
    info = (NodeInfo)node.getUserObject();

    // Toggle selection
    info.checked = !info.checked;

    // Make sure tree recalculates width of the nodes
    BasicTreeUI ui = (BasicTreeUI)getUI();
    try
    {
      Method method = BasicTreeUI.class.getDeclaredMethod("configureLayoutCache");
      method.setAccessible(true);
      method.invoke(ui);
    }
    catch (Exception e1)
    {
     e1.printStackTrace();
    }

  } // toggleCheckBox