public static void main(String[] args) {
    convertUnits("feet"); //Pass user input instead
    convertUnits("inches");
}


public static void convertUnits(String str)
{
    str = str.toUpperCase();
    switch (str) {
    case "FEET":
        System.out.println("Feet was called."); //Put what logic you need done in here
    break;
    case "INCHES":
        System.out.println("Inches was called.");
    break;
    case "MILLIMETERS":
        System.out.println("Millimeters was called.");
    break;
    //default:
    //etc...
    }
}