blueButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
        Object source = evt.getSource();
        Color color = getBackground();
        color = Color.blue;
        setBackground(color);
        repaint();
    }
});