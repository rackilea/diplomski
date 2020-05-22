/**
 * Returns a list with Strings which are rotated ROT-n. n = 26 - listIndex
 *
 * Source: http://www.rot-n.com/?page_id=4 
 *
 * @param input the string to mutate
 * @param numeric include numeric values
 * @return a list with mutated strings
 */
private static List<String> rotN(String input, boolean numeric) {
    List<String> output = new ArrayList<>();
    for (int n = 0; n < 26; n++) {
        String result = "";
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char ascii = input.charAt(i);
            char rotated = ascii;
            //Capital letters are 60 to 90
            if (ascii > 64 && ascii < 91) {
                rotated = (char) (rotated + n);
                if (rotated > 90) {
                    rotated += -90 + 64;
                }
                if (rotated < 65) {
                    rotated += -64 + 90;
                }
            } else if (ascii > 96 && ascii < 123) { //Lowercase letters are between 97 and 122
                rotated = (char) (rotated + n);
                if (rotated > 122) {
                    rotated += -122 + 96;
                }
                if (rotated < 97) {
                    rotated += -96 + 122;
                }
            }
            //Numeric values are between 48 to 57 
            if (numeric && ascii > 47 && ascii < 58) {
                rotated = (char) (rotated + n);
                if (rotated > 47) {
                    rotated += -57 + 47;
                }
                if (rotated < 58) {
                    rotated += -47 + 57;
                }
            }
            result += (char) rotated;
        }
        output.add(result);
    }
    return output;
}