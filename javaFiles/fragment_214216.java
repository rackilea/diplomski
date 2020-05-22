public static String stringTimes(String theString, int times)
{   
    if (times >= 1) {
        return theString + stringTimes(theString, times - 1);
    }
    return "";
}