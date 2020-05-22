/* encodeOrDecode = 0 for encode
** encodeOrDecode = 1 for decode
*/
public static String encodeDecode(int encodeOrDecode, String s, int code) {

    String result = "";

    if (encodeOrDecode == 1) {
        code *= -1;
    }

    for (int i = 0; i < s.length(); i++) {

        char ch = s.charAt(i);

        if (Character.isUpperCase(ch)) {
            ch += code;
            if (ch > 'Z') {
                ch -= 26;
            } else if (ch < 'A') {
                ch += 26;
            }
        } else if (Character.isLowerCase(ch)) {
            ch += code;
            if (ch > 'z') {
                ch -= 26;
            } else if (ch < 'a') {
                ch += 26;
            }
        }
        result += ch;
    }
    return result;
}