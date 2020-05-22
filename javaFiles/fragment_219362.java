public static void main(String[] args) {
    String firstString = "google out";
    String secondString = "stack overflow";
    char[] out = new char[firstString.length() + secondString.length()];
    int index = 0;
    for (char c : firstString.toCharArray()) {
        if (contains(secondString.toCharArray(), secondString.length(), c)) {
            out[index++] = c;
        }
    }
    char[] s = new char[index];
    for (int i = 0; i < index; i++) {
        s[i] = out[i];
    }
    System.out.println(Arrays.toString(s));
}