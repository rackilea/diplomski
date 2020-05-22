public JScrollPane createLayout() {

    JPanel panel = new JPanel();
    JScrollPane sp = new JScrollPane(panel);
    sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                    // or ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    panel.add(table1());
    panel.add(Box.createRigidArea(new Dimension(0,10)));
    panel.add(table2());
    panel.add(Box.createRigidArea(new Dimension(0,10)));


    return sp;
}