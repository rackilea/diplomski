public int getLineNumberFor(String lastName) {
    char c = lastName.charAt(0);
    if (c >= 'A' && c <= 'M') {
        return 1;
    } else if (c >= 'N' && c <= 'Z') {
        return 2;
    }
    return 0;
}