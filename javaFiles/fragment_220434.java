public static String passCheck(String password) {
    //String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,." + " ";
    String expected_pattern = "^[a-zA-Z0-9]{8,}$";
    String lowercase_pattern = "(.*)[a-z]+(.*)";
    String uppercase_pattern = "(.*)[A-Z]+(.*)";
    String digit_pattern = "(.*)[0-9]+(.*)";

    if (password == null || password.length() < 8) return ("You need at least 8 characters. ");     
    if (password.toLowerCase().equals("password")) return ("Your password cannot be password. ");
    if (!password.matches(lowercase_pattern)) return ("You need at least one lowercase. ");
    if (!password.matches(uppercase_pattern)) return ("You need at least one uppercase. ");
    if (!password.matches(digit_pattern)) return ("You need at least one digit. ");
    if (!password.matches(expected_pattern)) return ("Your password cannot contain special characters. ");

    return "Enter termination key";
}