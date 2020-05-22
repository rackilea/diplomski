String javacode="Your Java Code";
Pattern pattern = Pattern.compile("float"); //Java keyword
Matcher m = pattern.matcher(javacode);
SpannableString str = new SpannableString(javacode);
while (m.find()) {
str.setSpan(new BackgroundColorSpan(Color.YELLOW), m.start(), m.end()-1, 0);                       
}
textView.setText(str);