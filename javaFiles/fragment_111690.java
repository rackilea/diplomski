AssetManager am = getResources().getAssets();
    try {
        imgV = new ImageView(getApplicationContext());
        String[] names = am.list("image");          
        InputStream is = am.open("image/"+names[0]);
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        imgV.setImageBitmap(bitmap);
        is.close();
        this.addContentView(imgV, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    } catch (IOException e) {
        e.printStackTrace();
    }