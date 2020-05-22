parentComponent.add(nodeComponent);

    // Set the node's size and validate it so it's laid out properly
    nodeComponent.setBounds((int)realizer.getX(), (int)realizer.getY(), (int)realizer.getWidth(), (int)realizer.getHeight());

    nodeComponent.validate();

    // Now we can properly find the child component under our mouse
    Component componentTop = nodeComponent.findComponentAt(relativeX, relativeY);

    // Now remove it from the view
    parentComponent.remove(nodeComponent);