JSlider slider = new JSlider(JSlider.HORIZONTAL);
slider.setUI(new MetalSliderUI() {
    protected void scrollDueToClickInTrack(int direction) {
        // this is the default behaviour, let's comment that out
        //scrollByBlock(direction);

        int value = slider.getValue(); 

        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            value = this.valueForXPosition(slider.getMousePosition().x);
        } else if (slider.getOrientation() == JSlider.VERTICAL) {
            value = this.valueForYPosition(slider.getMousePosition().y);
        }
        slider.setValue(value);
    }
});