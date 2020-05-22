public void actionPerformed(ActionEvent e) {
    HistoryLogPane.setLayout(new ScrollPaneLayout());//<<<
    history = (JPanel)HistoryLogPane.getViewport().getView();//<<<
    javax.swing.JScrollPane HistoryLogPane = new javax.swing.JScrollPane();
    HistoryLogPane.setLayout(new ScrollPaneLayout()); // edit @kiheru
    HistoryLogPane.setBackground(Color.WHITE);
    HistoryLogPane.setBorder(BorderFactory.createEmptyBorder());
    HistoryLogPane.setLocation(0, 0);
    HistoryLogPane.add(history);
    HistoryLogPane.setSize(new Dimension(history.getSize()));
    history.setPreferredSize(history.getSize());//and we tried: history.setPreferredSize(history.getPreferredSize());
    history.revalidate();//<<<
    System.out.println("SIZE: " + HistoryLogPane.getSize());
    HistoryLocationPanel.removeAll();
    HistoryLocationPanel.add(HistoryLogPane);
    HistoryLocationPanel.repaint();
    HistoryLogPane.repaint();
}