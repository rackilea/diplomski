public static void main(String[] args) throws Exception {

    UIManager.getLookAndFeelDefaults().put("Slider.horizontalThumbIcon",new Icon(){
        @Override
        public int getIconHeight() {
            return 0;
        }
        @Override
        public int getIconWidth() {
            return 0;
        }
        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            //do nothing
        }
    });

    JFrame f = new JFrame();
    JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 30, 15);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(1);
    slider.setPaintTicks(true);
    slider.setPaintLabels(true);

    f.add(slider);
    f.setSize(200,200);
    f.setVisible(true);

}