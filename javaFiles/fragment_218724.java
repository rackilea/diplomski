public void actionPerfomed(ActionEvent e) {

    TableModel model = //... Create the new model based on you needs
    JTable table = new JTable(model);

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    frame.add(new JScrollPane(table));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

}