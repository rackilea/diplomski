public boolean isName(String check, char ch) {

    for (int i=0; i<name.length(); i++) {
        if (name.charAt(i) != check.charAt(i) && ch != check.charAt(i)) {
            return false;
        }
    }
    return true;
}