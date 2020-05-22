private void createUnderlinedText() {
    String text = "I am underlined text\nLine #2\nLine #3\nLine #4\nLine #5";

    EditText underlineSpanEditText = (EditText) findViewById(R.id.underlinespan_edittext);
    SpannableStringBuilder sb = new SpannableStringBuilder(text);
    sb.setSpan(new UnderlineSpan(), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    underlineSpanEditText.setText(sb);

    EditText htmlUnderlineEditText = (EditText) findViewById(R.id.html_underline_edittext);
    String html = "<u>I am underlined text</br>Line #2</br>Line #3</br>Line #4</br>Line #5</u>";
    htmlUnderlineEditText.setText(Html.fromHtml(html));
}