if(ae.getSource()==getOriginalTree)
    {
        System.out.println("Get original tree");
        System.out.println("Nodes present under cloned Root before deep copying");
        DisplayNodes(clonedRoot);
        getDeepCopy();
         System.out.println("Nodes present under cloned Root after deep copying");
         DisplayNodes(clonedRoot);
         DefaultTreeModel newModel = new DefaultTreeModel(clonedRoot);
         clonedTree.setModel(newModel);
         newModel.reload();
         for (int i = 0; i < clonedTree.getRowCount(); i++)
         {
         clonedTree.expandRow(i);
         }
         System.out.println("Updated tree");
    }