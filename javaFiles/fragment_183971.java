private static final String getPaddedValue(String toTest) {
    StringBuilder paddedvalue = new StringBuilder();
    int zeroCounter = countOfAvailableZeroInToken(toTest);
    for (int i = 0; i < 3 - zeroCounter; i++) {
        paddedvalue.append(toTest.substring(0, 2));
        for(int j= 0; j<=i; j++){
            paddedvalue.append("0");
        }
        paddedvalue.append(toTest.split("[a-zA-Z]{2}")[1]).append(" ");

        //change your if condition like this
        String lastPaddedValue = paddedvalue.toString().split("\\s")[paddedvalue.toString().split("\\s").length - 1];
        if(lastPaddedValue.length()-1>=6){
            break;
        }
    }
    return paddedvalue.toString();
}