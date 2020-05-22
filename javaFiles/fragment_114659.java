// Retrieve the three icons
Icon leafIcon = new ImageIcon("leaf.gif");
Icon openIcon = new ImageIcon("open.gif");
Icon closedIcon = new ImageIcon("closed.gif");

// Create tree
JTree tree = new JTree();

// Update only one tree instance
DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer)tree.getCellRenderer();
renderer.setLeafIcon(leafIcon);
renderer.setClosedIcon(closedIcon);
renderer.setOpenIcon(openIcon);

// Remove the icons
renderer.setLeafIcon(null);
renderer.setClosedIcon(null);
renderer.setOpenIcon(null);

// Change defaults so that all new tree components will have new icons
UIManager.put("Tree.leafIcon", leafIcon);
UIManager.put("Tree.openIcon", openIcon);
UIManager.put("Tree.closedIcon", closedIcon);

// Create tree with new icons
tree = new JTree();

// Update row height based on new icons;