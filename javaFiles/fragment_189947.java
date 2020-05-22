public static int addZeros(int valueToAddZeros, int valueToCompare){
    while(String.valueOf(valueToCompare).length() > String.valueOf(valueToAddZeros).length()){
        valueToAddZeros = valueToAddZeros * 10;
    }
    return valueToAddZeros;
}