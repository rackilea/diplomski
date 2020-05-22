final String faultyHtml = "Link: <a href=\"/images/nav_logo193.png\">click here</a> etc etc";
final String domain = "http://www.google.fr";

final String fixedHtml = faultyHtml.replace("href=\"/", "href=\"" + domain + "/");

text.setText(Html.fromHtml(fixedHtml));
text.setMovementMethod(LinkMovementMethod.getInstance());