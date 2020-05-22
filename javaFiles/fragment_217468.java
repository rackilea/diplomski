public JPanel init() {
    this.setBackground(Color.WHITE);
    MouseDrag md = new MouseDrag();
    this.addMouseListener(md);
    this.addMouseMotionListener(md);
    return this;
}