String encodeUserEmail(String userEmail) {
    return userEmail.replace(".", ",");
}

String decodeUserEmail(String userEmail) {
    return userEmail.replace(",", ".");
}