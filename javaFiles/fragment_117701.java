slider.setUI(new BasicSliderUI(slider) {
    public void paintThumb(Graphics g) {
        super.paintThumb(g);
        g.setColor(Color.RED);
        g.drawString(slider.getValue() + "", thumbRect.x, thumbRect.y + thumbRect.height);
    }
});