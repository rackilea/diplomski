private Image[] imgs;
private int currentImgIndex;
private JLabel imageComponent = new JLabel();
private Action nextAction = new AbstractAction() {
    {
        putValue(NAME, "Next");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        currentImgIndex = (currentImgIndex + 1) % imgs.length;
        imageComponent.setIcon(new ImageIcon(imgs[currentImgIndex]));
        imageComponent.repaint(50L);
    }
};