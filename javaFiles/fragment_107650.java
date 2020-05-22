btn.putClientProperty("value", 1);

public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source instanceof JButton) {
        JButton btn = (JButton)source;
        value = (Integer)btn.getClientProperty("value");