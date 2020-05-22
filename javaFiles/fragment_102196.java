private int getIntValue(String inputValue, int defaultValue) {
    try {
        return inputValue!=null?Integer.parseInt(inputValue):defaultValue;
    }
    catch(Exception e) {
        return defaultValue;
    }
}