public float getXTextOffset(float textWidth, float fontPadding) {
    if (getLocation() == Location.TOP)
        return (textWidth / 2 + fontPadding) * -1;
    else if (getLocation() == Location.BOTTOM)
        return (textWidth / 2 + fontPadding) * -1;
    else if (getLocation() == Location.RIGHT)
        return 0 + fontPadding;
    else
        return (textWidth + fontPadding) * -1;
}

public float getYTextOffset(float fontSize, float fontPadding) {
    if (getLocation() == Location.TOP)
        return 0 + fontPadding;
    else if (getLocation() == Location.BOTTOM)
        return (fontSize + fontPadding) * -1f;
    else
        return fontSize / 2 * -1;
}