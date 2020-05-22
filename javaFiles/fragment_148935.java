private void setText(String text){
    String regexPattern = "(http|www)\\S*";
    final Matcher matcher = Pattern.compile(regexPattern).matcher(text);
    SpannableStringBuilder strBuilder = new SpannableStringBuilder(text);
    while(matcher.find()){

        ClickableSpan clickable = new ClickableSpan() {
            public void onClick(View view) {
                // Do something with span.getURL() to handle the link click...
            }
        };

        strBuilder.setSpan(clickable, matcher.start(), matcher.end(), 0);

    }
}