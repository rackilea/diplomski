JLabel label = new JLabel("x");
label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
label.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("woah!!");
    }
});


setTabComponentAt(indexOfComponent(blankJPanel), label);