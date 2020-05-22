private static boolean isPasswordValid(String password) {
    boolean valid = true;
    // at least one lowercased char
    valid &= password.matches(".*[a-z].*");
    // at least one uppercased char
    valid &= password.matches(".*[A-Z].*");
    // at least one digit
    valid &= password.matches(".*[0-9].*");
    // at least one special char
    valid &= password.matches(".*[!@#$%^&*()_'\"+={};:<>,.?/-].*");
    // length & no other char
    valid &= password.matches("[a-zA-Z0-9!@#$%^&*()_'\"+={};:<>,.?/-]{8,32}");
    return valid;
}