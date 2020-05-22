Bitmap bitmapsave = null;
       //get image bitmap from imageview 
        bitmapsave = ((BitmapDrawable) imageView.getDrawable()).getBitmap();


       //create folder where you want to store compressed image
       File file = new File(Environment.getExternalStorageDirectory().getPath(), "/yourAppname");
        if (!file.exists())
        {
            file.mkdirs();
        }
            // name that image
            String filename = file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg";

    FileOutputStream out = null;
    try
    {
        out = new FileOutputStream(filename);
        bitmapsave.compress(Bitmap.CompressFormat.JPEG, 50, out);
        out.close();

        Toast.makeText(getApplicationContext(), "saved successfully", Toast.LENGTH_SHORT).show();
     }
    catch (FileNotFoundException e)
    {
        e.printStackTrace();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }