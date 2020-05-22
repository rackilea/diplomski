int i = 1;
while (i < 50) {
    JLabel label = new JLabel(String.valueOf(i));
    label.setIcon(new ImageIcon(ClientGUI.class .getResource("/resources/wall.jpg")));
    pnlMap.add(label);
    i += 1;
}