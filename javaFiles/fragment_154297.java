public void stateChanged(ChangeEvent e) {
    int sliderValue = jslider.getValue();
    int lowerMedian=(0+20)/2;
    int upperMedian=(0+50)/2;
    if (sliderValue >= 0 && sliderValue <= 20 && sliderValue == lowerMedian) {
        System.out.println("Between 0 and 20");
    } else if (sliderValue > 20 && sliderValue <= 50 && sliderValue == upperMedian) {
        System.out.println("You're 20 - 50");
    }
}