public static String[] setWeightPercentageToOunce() {
    String[] listStringBuffer = new String[ ouncesArray.length ];
    double moduloChecker;
    for (int i=0;i<ouncesArray.length;i++){
        double stringToDouble = Double.parseDouble(ouncesArray[i]);
        moduloChecker = stringToDouble % 625; // checks to verify the value is divisible by 625 with no remainder
        if (moduloChecker != 0) { // if there's a remainder, the value is invalid and should be replaced with "Invalid Entry".
            listStringBuffer[i] = "Invalid Entry!";
        } else {
            double conversion = stringToDouble / 625; // converts weight percentage to ounce and stores in double variable
            String str = Double.toString(conversion);
            listStringBuffer[i] = str;
        }
    }
    return listStringBuffer;
}