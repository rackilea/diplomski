case 4:
    try {
        Bitmap bitmap = Bitmap.createBitmap(d.getWidth(),d.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        d.draw(canvas);
        File folder = new File(Environment.getExternalStorageDirectory()+ "/DCIM/Camera/");
        if (!folder.exists())
            folder.mkdirs();
        String fileName = Environment.getExternalStorageDirectory()+ "/DCIM/Camera/img.jpg"";
        if (new File(fileName).exists())
            new File(fileName).delete();
        OutputStream stream = new FileOutputStream(fileName);
        /*
         * Write bitmap to file using JPEG or PNG and 100% quality hint
         * for JPEG.
         */
        bitmap.compress(CompressFormat.JPEG, 100, stream);
        stream.close();
        } catch (Exception e) {
                // TODO Auto-generated catch block
                Toast.makeText(this, "Error: " + e.getMessage(),Toast.LENGTH_LONG).show();
        }
        break;