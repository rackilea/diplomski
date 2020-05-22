private static SpannableStringBuilder setTextColor(Context context, SpannableStringBuilder Text, int spanLength, boolean isSuggestion) {
    int color = context.getResources().getColor(isSuggestion ? R.color.blur : R.color.red);

    addressText.setSpan(new ForegroundColorSpan(color),
            addressText.length() - 1 - spanLength,
            addressText.length(),
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    return Text;
}