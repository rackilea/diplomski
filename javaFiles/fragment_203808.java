String text = "the {quic}k brown {fox} jumps {over} the lazy dog. {A Quick} {brow}nfoxjumpsoverthelazydog";

tv.setText(makeSpannable(text, "\\{.*?\\}"));

public SpannableStringBuilder makeSpannable(String text, String regex) {

    StringBuffer sb = new StringBuffer();
    SpannableStringBuilder spannable = new SpannableStringBuilder();

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
        sb.setLength(0); // clear
        String group = matcher.group();
        // caution, this code assumes your regex has single char delimiters
        String spanText = group.substring(1, group.length() - 1);
        matcher.appendReplacement(sb, spanText);

        spannable.append(sb.toString());
        int start = spannable.length() - spanText.length();

        spannable.setSpan(new ForegroundColorSpan(Color.RED), start, spannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    sb.setLength(0);
    matcher.appendTail(sb);
    spannable.append(sb.toString());
    return spannable;
}