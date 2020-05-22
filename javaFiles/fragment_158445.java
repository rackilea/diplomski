public static class ViewProvider extends AbstractCellEditor 
    implements TreeCellEditor, TreeCellRenderer {

    private JCheckBox firstBox;
    private JButton colorButton;
    private JComponent nodePanel;
    private JButton nameButton;

    private Data data;
    private boolean ignore;

    public ViewProvider(boolean asEditor) {
        initComponents();
        if (asEditor)
          installListeners();
    }

    protected void initComponents() {
        nodePanel = new JPanel();
        nodePanel.setOpaque(false);
        firstBox = new JCheckBox();
        colorButton = new JButton();
        // if we need something clickable use something ... clickable :-)
        nameButton = new JButton();
        nameButton.setContentAreaFilled(false);
        nameButton.setOpaque(true);
        nameButton.setBorderPainted(false);
        nameButton.setMargin(new Insets(0, 0, 0, 0));
        nodePanel.add(firstBox);
        nodePanel.add(colorButton);
        nodePanel.add(nameButton);
    }

    protected void installListeners() {
        ActionListener cancel = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelCellEditing();
            }

        };
        nameButton.addActionListener(cancel);
        ActionListener stop = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stopCellEditing();
            }

        };
        firstBox.addActionListener(stop);
        // Note: code for using a button to trigger opening a dialog
        // is in the tutorial, should replace this
        colorButton.addActionListener(stop);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row,
            boolean hasFocus) {
        Data data = (Data) ((DefaultMutableTreeNode) value).getUserObject();
        firstBox.setSelected(data.isVisible);
        colorButton.setBackground(data.color);
        nameButton.setText(data.name);
        nameButton.setBackground(selected ? Color.YELLOW : tree.getBackground());
        nameButton.setFont(tree.getFont());
        return nodePanel;
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value,
            boolean isSelected, boolean expanded, boolean leaf, int row) {
        // copy to not fiddle with the original
        data = new Data((Data) ((DefaultMutableTreeNode) value).getUserObject());
        ignore = true;
        getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, false);
        ignore = false;
        return nodePanel;
    }

    @Override
    public Object getCellEditorValue() {
        return data;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        // at this point the editing component is added to the tree
        // and the mouse coordinates still in tree coordinates
        if (anEvent instanceof MouseEvent) {
            MouseEvent me = (MouseEvent) anEvent;
            Point loc = SwingUtilities.convertPoint(me.getComponent(), 
                    me.getPoint(), nodePanel);
            return loc.x >= nameButton.getX();
        }
        return false;
    }

    @Override
    public boolean stopCellEditing() {
        if (ignore) return false;
        // real-world data will have setters
        data.isVisible = firstBox.isSelected();
        return super.stopCellEditing();
    }

    @Override
    public void cancelCellEditing() {
        if (ignore) return;
        data = null;
        super.cancelCellEditing();
    }

}

// simple Data - obviously not for production 
public static class Data {
    boolean isVisible;
    Color color;
    String name;

    public Data(boolean isVisible, Color color,
            String name) {
        this.isVisible = isVisible;
        this.color = color;
        this.name = name;
    }

    /**
     * A copy constructor to allow editors to manipulate its
     * properties without changing the original.
     * 
     * @param original
     */
    public Data(Data original) {
        this.isVisible = original.isVisible;
        this.color = original.color;
        this.name = original.name;
    }
}

// usage:
DefaultMutableTreeNode root = new DefaultMutableTreeNode(
    new Data(true, Color.RED, "someName"));
root.add(new DefaultMutableTreeNode(new Data(true, Color.GREEN, "other")));
root.add(new DefaultMutableTreeNode(new Data(false, Color.BLUE, "whatagain")));
root.add(new DefaultMutableTreeNode(new Data(false, Color.YELLOW, "dummy")));

JTree tree = new JTree(root);
tree.setCellRenderer(new ViewProvider(false));
tree.setCellEditor(new ViewProvider(true));
tree.setEditable(true);