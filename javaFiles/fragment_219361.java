// Write a static helper method.
public static boolean contains(char[] in, int index, char t) {
    for (int i = 0; i < index; i++) {
        if (in[i] == t) return true;
    }
    return false;
}

public static void main(String[] args) {
    String firstString = "google out"; // String(s) not String arrays
    String secondString = "stack overflow";
    // output cannot be larger then the sum of the inputs.
    char[] out = new char[firstString.length() + secondString.length()];
    int index = 0;
    // Add all unique chars from firstString
    for (char c : firstString.toCharArray()) {
        if (! contains(out, index, c)) {
            out[index++] = c;
        }
    }
    // Add all unique chars from secondString
    for (char c : secondString.toCharArray()) {
        if (! contains(out, index, c)) {
            out[index++] = c;
        }
    }
    // Create a correctly sized output array.
    char[] s = new char[index];
    for (int i = 0; i < index; i++) {
        s[i] = out[i];
    }
    // Just print it.
    System.out.println(Arrays.toString(s));
}