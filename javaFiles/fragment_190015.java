private static String getRepresantationOfLowIntValue(int toConvert) {
    if(toConvert >= 0 && toConvert < 10) {
        return "" + toConvert;
    }

    switch(toConvert) {
        case 10 : return "A";
        case 11 : return "B";
        case 12 : return "C";
        case 13 : return "D";
        case 14 : return "E";
        case 15 : return "F";
    }

    return "Error, cannot transform number < 0 or > 15";
    //throw new IllegalArgumentException("cannot transform number < 0 or >15");
}