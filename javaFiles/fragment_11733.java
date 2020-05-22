/**
 * For setting mandatory fields  symbol     *     * @param hintData     * @return
 */
public SpannableStringBuilder setMandatoryHintData(String hintData) {
    String simple = hintData;
    String colored = " *";
    SpannableStringBuilder builder = new SpannableStringBuilder();
    builder.append(simple);
    int start = builder.length();
    builder.append(colored);
    int end = builder.length();
    builder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorGrayLight_75)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    return builder;
}