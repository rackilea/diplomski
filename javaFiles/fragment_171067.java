String green = "#99FFCC";
adjustColor(green);

private int adjustColor(String color) {
    /* Get RGB Value Of Color */
    int colorToAdjust = Color.parseColor(color);

    /* Get Red Value From RGB */
    int redAmount = Color.red(colorToAdjust);

    /* Return New Color By Halving Red */
    return Color.rgb(0.5 * redAmount, Color.green(colorToAdjust), 
                     Color.blue(colorToAdjust));
}