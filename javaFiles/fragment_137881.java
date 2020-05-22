// this function colors the k-th character of String s in blue and the rest in red, and returns the SpannableString
public static SpannableString highlight(String s, int k) {
        SpannableString ss = new SpannableString(s);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 0, k, 0);
        ss.setSpan(new ForegroundColorSpan(Color.RED), k, k + 1, 0);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), k + 1, s.length(), 0);
        return ss;
    }