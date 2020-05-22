final Intent shareIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
shareIntent.putExtra(Intent.EXTRA_SUBJECT, "The Subject");
shareIntent.putExtra(
Intent.EXTRA_TEXT,
Html.fromHtml(new StringBuilder()
    .append("<p><b>Some Content</b></p>")
    .append("<small><p>More content</p></small>")
    .toString())
);