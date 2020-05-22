final JTree tree = new JTree();
    tree.setEditable(true);
    // this will often help (see its api doc), but no guarantee
    tree.setInvokesStopCellEditing(true);
    // a focusListener is **not** helping
    FocusListener l = new FocusListener() {

        @Override
        public void focusGained(FocusEvent e) {
        }

        @Override
        public void focusLost(FocusEvent e) {
            // this would prevent editing at all
           // tree.stopEditing();
        }

    };
    tree.addFocusListener(l);
    JComponent panel = new JPanel(new BorderLayout());
    panel.add(new JScrollPane(tree));
    panel.add(new JButton("just something to focus"), BorderLayout.SOUTH);