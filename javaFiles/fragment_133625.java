public static class LabelListener implements MouseListener {
    private ImageIcon newIcon;
    private ImageIcon defaultIcon;
    private JLabel label;
    public LabelListener(JLabel label, String newIconPath, String defaultIconPath) throws IOException{
            this.label = label;
            this.label.setSize(100, 100);
            this.newIcon = new ImageIcon(newIconPath);
            this.defaultIcon = new ImageIcon(defaultIconPath);
            this.label.setIcon(this.defaultIcon);
    }
    @Override
    public void mouseEntered(MouseEvent evt){
            this.label.setIcon(this.newIcon);
    }
    @Override
    public void mouseExited(MouseEvent evt){
            this.label.setIcon(this.defaultIcon);
    }
    @Override
    public void mousePressed(MouseEvent evt){
    }
    @Override
    public void mouseClicked(MouseEvent evt){
    }
    @Override
    public void mouseReleased(MouseEvent evt){
    }
}