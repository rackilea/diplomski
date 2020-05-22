final JComponent parent = new JPanel(); // new PageScrollable();
parent.setLayout(new BoxLayout(parent, BoxLayout.PAGE_AXIS));
Color[] color = new Color[] {Color.YELLOW, Color.RED, Color.GREEN}; 
for (int i = 0; i < color.length; i++) {
    JTable table = new JTable(10, 5);
    // color it to see some difference
    table.setBackground(color[i]);
    // set a name for logging
    table.setName("table at: " + i);
    parent.add(table);
}

JScrollPane scrollPane = new JScrollPane(parent);
Action visible = new AbstractAction() {

    @Override
    public void actionPerformed(ActionEvent e) {
        Rectangle rect = parent.getVisibleRect();
        for (int i = 0; i < parent.getComponentCount(); i++) {
            // implement logic as needed to compare the parent's visible rect
            // with the children's bounds
            if (rect.intersects(parent.getComponent(i).getBounds())) {
                System.out.println("found: " + parent.getComponent(i).getName());
            }
        }
    }

};
frame.add(scrollPane); 
frame.add(new JButton(visible), BorderLayout.SOUTH);