TextView contentView = (TextView)view.findViewById(R.id.contentPreview);
SpannableString contentText = (SpannableString) contentView.getText();
String htmlEncodedString = Html.toHtml(contentText);
String decodedString = StringEscapeUtils.unescapeHtml4(htmlEncodedString);

Log.e("Content Text",decodedString);