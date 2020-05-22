Intent shareIntent = null;

if(uris.size > 1) {
    shareIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
    shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
}
else {
    if (uris.size() == 1) {
        shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uris.get(0));
    }
}
shareIntent.setType("image/*");
shareIntent.putExtra(Intent.EXTRA_SUBJECT, curentWit.getWit_name());
shareIntent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(shrd).toString());

startActivity(shareIntent);