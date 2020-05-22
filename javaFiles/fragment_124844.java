Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image_name);     
ByteArrayOutputStream os = new ByteArrayOutputStream();
byte[] data = os.toByteArray();

Intent intent = new Intent(this, Activity2.class);
intent.putExtra("image", data);
startActivity(intent);