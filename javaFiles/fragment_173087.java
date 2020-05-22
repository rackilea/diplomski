public class CommaTokenizer implements MultiAutoCompleteTextView.Tokenizer {
    public int findTokenStart(CharSequence text, int cursor) {
        int i = cursor;

        while (i > 0) {
            if ((text.charAt(i - 1) == ';') || (text.charAt(i - 1) == ',')) {
                return i - 1;
            }
            i--;
            return i;
        }

        return i;
    }

    public int findTokenEnd(CharSequence text, int cursor) {
        int i = cursor;
        int len = text.length();

        while (i < len) {
            if ((text.charAt(i) == ';') || (text.charAt(i) == ',')) {
                return i;
            } else {
                i++;
            }
        }

        return len;
    }

    public CharSequence terminateToken(CharSequence text) {
        int i = text.length();

        while (i > 0 && text.charAt(i - 1) == ' ') {
            i--;
        }

        if (i > 0 && ((text.charAt(i - 1) == ';') || (text.charAt(i - 1) == ','))) {
            return text;
        } else {
            if (text instanceof Spanned) {
                SpannableString sp = new SpannableString("");
                if (i > 0 && (text.charAt(i - 1) == ';')) {
                    sp = new SpannableString(text + ";");
                } else if (i > 0 && (text.charAt(i - 1) == ',')) {
                    sp = new SpannableString(text + ",");
                }
                TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                        Object.class, sp, 0);
                return sp;
            } else {
                if (i > 0 && (text.charAt(i - 1) == ',')) {
                    return text + ",";
                } else {
                    return text + ";";
                }
            }
        }
    }
}