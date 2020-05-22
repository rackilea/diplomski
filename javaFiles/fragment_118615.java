static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

static void getChars(char[] lastChars, int pos, int length) {
    for (char c : letters) {
        char[] newChars = lastChars.clone();
        newChars[pos] = c; // if you have "aa" for example and the current length is 4. If c = "a", newChars is now "aaa"
        if (pos + 1 < length) { // as your lenths is 4 and you still have only 3 letters, getChars adds the missing ones
            getChars(newChars, pos + 1, length);
        } else {
            System.out.println(newChars);
        }
    }
}

public static void main(String[] args) {
    int maxLength = 4;

    for (int length = 1; length <= maxLength; length++) {
        for (char c : letters) {
            if (length > 1) {
                char[] chars = new char[length];
                chars[0] = c;
                getChars(chars, 1, length);
            } else {
                System.out.println(c);
            }
        }
    }

}