try {
    JButton button = new JButton(new ImageIcon(((new ImageIcon(
        new URL("http://i68.tinypic.com/2itmno6.jpg"))
        .getImage()
        .getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)))));
    button.setBorder(BorderFactory.createEmptyBorder());
    button.setContentAreaFilled(false);
    panel.setOpaque(false);
    panel.add(button);

    button.addActionListener(new Action7());
} 
catch (MalformedURLException e) {
    // exception handler code here
    // ...
}