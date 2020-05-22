Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
    Image img = null;
    byte[] byteArray = stream.toByteArray();
    try {
        img = Image.getInstance(byteArray);
    } catch (BadElementException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }