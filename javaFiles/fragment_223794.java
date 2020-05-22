public static String cleanup(String inputPhoneNumber) {
    String cleanedUp = inputPhoneNumber.replaceAll("[^\\d]", "");
    if(inputPhoneNumber.startsWith("+")){
        return "+" + cleanedUp;
    }
    return cleanedUp;
}