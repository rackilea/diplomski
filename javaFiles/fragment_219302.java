try {
        FileInputStream l = openFileInput("filename.jpg");
        Bitmap A = BitmapFactory.decodeStream(l);
        LinearLayout bg = (LinearLayout) findViewById(R.id.layoutid);
        Drawable drawable = new BitmapDrawable(getResources(), A);
        bg.setBackgroundDrawable(drawable);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }