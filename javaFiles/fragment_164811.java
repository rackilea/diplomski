JSlider slider = new JSlider();
WindowsSliderUI s = new WindowsSliderUI(slider) {
    @Override
    public void paintFocus(Graphics g) {
        // dont paint focus
    }
};
slider.setUI(s);