public static final String FEET = "FROMFEET";
public static final String INCHES = "INCHES";
public static final String MILLIMETERS = "MILLIMETERS";

public static void main(String[] args) {
    checkUnits("feet","inches", 2);
    checkUnits("inches","feet", 1);
}


public static void checkUnits(String from, String to, int units)
{
    from = from.toUpperCase();
    switch (from) {
    case "FEET":
        convertUnits(FEET,to, units);
    break;
    case "INCHES":
        convertUnits(INCHES,to, units);
    break;
    case "MILLIMETERS":
        convertUnits(MILLIMETERS,to, units);
    break;
    //default:
    //etc...
    }
}

public static void convertUnits(String from, String to, int units)
{
    to = to.toUpperCase();
    switch (to) {
    case "FEET":
        System.out.println("FROM: " + from + " to: " + to + " Units: " + units);
    break;
    case "INCHES":
        System.out.println("FROM: " + from + " to: " + to + " Units: " + units);
    break;
    case "MILLIMETERS":
        System.out.println("FROM: " + from + " to: " + to + " Units: " + units);
    break;
    //default:
    //etc...
    }
}