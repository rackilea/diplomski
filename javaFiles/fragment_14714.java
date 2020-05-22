try {
    if( Integer.parseInt(lowerLimit) < 1 || Integer.parseInt(upperLimit) > 999 ) {
        return "The string must be in the range 0-999";
    }
} catch (NumberFormatException e) {
        return "The string must be in the range 0-999";
        //or more relevant message, like "Number to long" or something
}