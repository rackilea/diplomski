@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    ...
    String text = resultCode.getContents();
    if (Patterns.WEB_URL.matcher(text).matches()) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(text));
        startActivity(browserIntent);
    } else {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}