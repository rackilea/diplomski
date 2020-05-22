public void hightLightText(TextView textView, String searchString) {
    String s = textView.getText().toString();
    SpannableString str = new SpannableString(s);
    if (searchString != null && !searchString.equalsIgnoreCase("")) {
        int startIndex = 0;
        while (true) {
            startIndex = s.indexOf(searchString, startIndex);

            if (startIndex >= 0) {
                str.setSpan(new BackgroundColorSpan(Color.YELLOW),
                        startIndex, startIndex + searchString.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                startIndex++;
            } else {
                break;
            }
        }
    }
    textView.setText(str);
}