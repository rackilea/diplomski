ImageIcon image = item.getIcon();
JLabel labelWithImage = new JLabel(image);
labelWithImage.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered Over Image");
    }
});
panel.add(labelWithImage);