TextView text = (TextView) findViewById(R.id.text);
text.setText("");
String linkName = "@appamatto";
String linkUrl = "http://twitter.com/appamatto"
SpannableString str = SpannableString.valueOf(linkName);
str.setSpan(new URLSpan(linkUrl), 0, linkName.length(),
    Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
str.setSpan(new ForegroundColorSpan(0xffffffff), 0, linkName.length(),
    Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
str.setSpan(new BackgroundColorSpan(0xff0099ff), 0, linkName.length(),
    Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
text.append(str);