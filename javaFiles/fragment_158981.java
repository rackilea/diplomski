public Color darker() {
    return new Color(Math.max((int)(getRed()  *FACTOR), 0),
                     Math.max((int)(getGreen()*FACTOR), 0),
                     Math.max((int)(getBlue() *FACTOR), 0),
                     getAlpha());
}