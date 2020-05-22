public String getString(Object object) {
    int number = Integer.parseInt(object.toString().trim());
    if(number < 10) {
        return "0" + number;
    }
    return String.valueOf(number);
}