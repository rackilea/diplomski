Pattern pattern = Pattern.compile("tree");
Matcher matcher = pattern.matcher(yourTextViewText);

final SpannableStringBuilder spannableBuilder = new SpannableStringBuilder(yourTextViewText);
final ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
while (matcher.find()) {
    spannableBuilder.setSpan(
        span, matcher.start(), matcher.end(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
}
yourTextView.setText(spannableBuilder);