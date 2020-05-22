if (selectedRectangle != null) {
    red = (int) ColorSlider.getValue();
    selectedRectangle.setFill(Color.rgb(red, green, blue));
} else if (selectedCircle != null && selectedRectangle == null) {
    red = (int) ColorSlider.getValue();
    selectedCircle.setFill(Color.rgb(red, green, blue));
}