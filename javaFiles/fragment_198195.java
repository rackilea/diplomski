boolean containsUpperCase(String value) {
    for (char ch : value.toCharArray()) {
        if (Character.isUpperCase(ch)) {
            return true;
        }
    }
    return false;
}