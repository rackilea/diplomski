final JButton b = new JButton("Press me");
b.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        final DefaultListModel<String> model = new DefaultListModel<>();
        for (int i = 0; i < 100; i++)
            model.addElement(i + ".");
        final JList<String> l = new JList<>(model);

        final JPopupMenu pm = new JPopupMenu();
        final JScrollPane sp = new JScrollPane(l);
        // pm.setPreferredSize(new Dimension(100, 300));
        pm.add(sp);
        pm.show(b, 0, 0);
    }
});