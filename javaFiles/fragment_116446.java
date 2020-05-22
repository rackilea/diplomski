for (Map.Entry<String, String> entry : file.entrySet()) {
    String key = entry.getKey();
    String values[] = entry.getValue().split("\\|");

    DefaultMutableTreeNode parent = top;
    for (String k : values) {
        DefaultMutableTreeNode n = null;

        Enumeration<?> e = parent.children();
        while (e.hasMoreElements()) {
            n = (DefaultMutableTreeNode) e.nextElement();
            if (k.equals(n.getUserObject())) {
                // Existing node matches; use that one.
                break;
            }
            n = null;
        }

        if (n == null) {
            // No existing node matches;  add it.
            n = new DefaultMutableTreeNode(k);
            parent.add(n);
        }

        parent = n;
    }

    DefaultMutableTreeNode keyn = new DefaultMutableTreeNode(key);
    parent.add(keyn);
}