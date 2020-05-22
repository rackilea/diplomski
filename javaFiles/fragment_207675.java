HttpPost post = new HttpPost("http://localhost:1767/ImageService.svc/add/1/RESTjava");

Bitmap img = ((BitmapDrawable)getResources().getDrawable(R.drawable.entourage)).getBitmap();
ByteArrayOutputStream bao = new ByteArrayOutputStream();
img.compress(Bitmap.CompressFormat.JPEG, 90, bao);
byte[] data = bao.toByteArray();

ByteArrayEntity bimg = new ByteArrayEntity(data);
post.setEntity(bimg);
new DefaultHttpClient().execute(post);