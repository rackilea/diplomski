feedItemView.messageText.setText(yeet.getString(ParseConstants.KEY_NOTIFICATION_TEXT));

Linkify.TransformFilter filter = (match, url) -> match.group();

Pattern mentionPattern = Pattern.compile("@([A-Za-z0-9_-]+)");
String mentionScheme = "http://www.twitter.com/";
Linkify.addLinks(feedItemView.messageText, mentionPattern, mentionScheme, null, filter);