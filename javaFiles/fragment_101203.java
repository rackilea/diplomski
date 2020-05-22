for (int i = 0; i < chars.length; i++)
    chars[i] = false;

.
.
.

public static void randomChar() {
    for (int i = 0; i < playerNum; i++) {
        do {
            chooseChar = rnd.nextInt(14);
        } while (chars[chooseChar]); // This is never true...