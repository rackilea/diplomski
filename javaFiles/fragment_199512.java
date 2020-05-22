Spannable r1Span = new SpannableString(r1);
Spannable r2Span = new SpannableString(r2);
Spannable r3Span = new SpannableString(r3);

r1Span.setSpan(new ForegroundColorSpan(Color.RED), 0, r1.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
r2Span.setSpan(new ForegroundColorSpan(Color.RED), 0, r2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
r3Span.setSpan(new ForegroundColorSpan(Color.RED), 0, r3.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

String result = TextUtils.concat("creat result" +
"\n salaz " + r1Span+
"\n jalf " +r2Span+
"\n mdar" +r3Span); 

result.setText (result);