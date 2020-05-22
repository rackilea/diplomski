public Color(int red, int green, int blue) {

    this.red = setColorLimits(red);
    this.green = setColorLimits(green);
    this.blue = setColorLimits(blue);
}

public Color() {}