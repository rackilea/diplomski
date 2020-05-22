TextView upTextView = (TextView) getLayoutInflater().inflate(
        R.layout.up_text, null);
upTextView.setText("CITIES");
upTextView.measure(0, 0);
upTextView.layout(0, 0, upTextView.getMeasuredWidth(), 
        upTextView.getMeasuredHeight());
Bitmap bitmap = Bitmap.createBitmap(upTextView.getMeasuredWidth(),
        upTextView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
Canvas canvas = new Canvas(bitmap);
upTextView.draw(canvas);
BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);