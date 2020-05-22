public BottomPanel() {
    setLayout(new GridBagLayout());
    entryPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
    setComponents();
    Dimension dim = getPreferredSize();
    System.out.println(dim);
    setPreferredSize(dim);
}