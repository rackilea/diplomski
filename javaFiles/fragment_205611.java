public String getNewNumber(String[] listNumbers) {
    int lastNumber = 1;
    for (String listNumber : listNumbers) {
        String splitNumber = listNumber.split("\\D")[0];
        int parsedNumber = Integer.parseInt(splitNumber);
        if(parsedNumber > lastNumber) {
            lastNumber = parsedNumber;
        }
    }
    int newNumber = lastNumber + 1;
    return String.valueOf(newNumber);
}