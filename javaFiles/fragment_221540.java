@Override
 protected void onPostExecute(Drawable result) {
    result.setBounds(0, 0, result.getIntrinsicWidth(), result.getIntrinsicHeight());
    urlDrawable.setBounds(0, 0, result.getIntrinsicWidth(), result.getIntrinsicHeight());
    urlDrawable.drawable = result;
    URLImageParser.this.container.setMinimumHeight(result.getIntrinsicHeight());
    URLImageParser.this.container.requestLayout();
    URLImageParser.this.container.invalidate();
 }