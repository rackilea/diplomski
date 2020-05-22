public void actionPerformed(ActionEvent e) {
    JButton sourceButton = (JButton)e.getSource();
    F1 f1 = (F1)sourceButton.getParent().getParent();
    Data myData = f1.getMyData();
    data.setField(...);
}