private void saveImagetoGallery(Bitmap finalBitmap){

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root+"/saveImage");
        myDir.mkdirs();
        Random random = new Random();
        int n = 10000;
        n = random.nextInt(n);
        String imageName = "Image"+n+".jpg";
        File file = new File(myDir,imageName);
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        if(file.exists())file.delete();
        try{
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG,90,out);
            String string = file.getAbsolutePath();
            Uri contentUri = Uri.fromFile(file);
            mediaScanIntent.setData(contentUri);
            this.sendBroadcast(mediaScanIntent);
            out.flush();
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }