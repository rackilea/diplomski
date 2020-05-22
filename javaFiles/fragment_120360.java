public String toString() {
    String description = "";
    if (fanOn = true) {
        description += "The speed of the fan is " + speed
                + ", the color  of the the fan is " + color
                + ", and the radius of the fan is " + radius + ".";
    } else {
        description += "The fan is off but the color is " + color
                + " and the radius is " + radius + ".";
    }
    return description;
}