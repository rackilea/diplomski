new DefaultMutableTreeNode("a") {{
  add(new DefaultMutableTreeNode("a1") {{
    add(new DefaultMutableTreeNode("b1"))
  }})
  add(new DefaultMutableTreeNode("a2"))
  add(new DefaultMutableTreeNode("a2"))
}}