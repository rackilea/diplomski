DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();

    String xpath = "";
    while (selected.getParent() != null) {
        int index = 1;
        String tag = selected.toString();
        DefaultMutableTreeNode selected2 = selected;
        while ((selected2 = selected2.getPreviousSibling()) != null) {
            if (tag.equals(selected2.toString())) index++;
        }

        xpath = "/" + tag + "[" + index + "]" + xpath;
        if (selected.getParent() == null) {
            selected = null;
        } else {
            selected = (DefaultMutableTreeNode) selected.getParent();
        }
    }

    LOG.info(xpath);