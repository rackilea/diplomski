protected void randomiseColor() {

    int red = (int) (Math.round(Math.random() * 255));
    int green = (int) (Math.round(Math.random() * 255));
    int blue = (int) (Math.round(Math.random() * 255));

    setForeground(new Color(red, green, blue));

}