BasicSliderUI sliderUI = new BasicSliderUI(slider) {
    @Override
    public void paintFocus(Graphics g) {
        // dont paint focus
    }
};
slider.setUI(sliderUI);