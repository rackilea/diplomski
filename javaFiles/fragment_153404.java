menu.setOnShown(e -> {
        Node node = separatorMenuItem.getContent();
        do {
            System.out.println("Node: " + node);
            node = node.getParent();
        } while (node != null);
    });