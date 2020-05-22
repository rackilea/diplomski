public static String saveImageFile(Bitmap image, String folder){

    String now = Long.toString(new Date().getTime());

    File imageFile = new File(Environment.getExternalStorageDirectory() + folder);
    if (!imageFile.exists()){
        File screenShotsFolder = new File("/sdcard/Pictures/" + folder+ "/");
        screenShotsFolder.mkdirs();
    }

    File imageName = new File(new File("/sdcard/Pictures/" + folder + "/"), now + ".jpg" );

    try{
        FileOutputStream outputStream = new FileOutputStream(imageName);
        image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        outputStream.flush();
        outputStream.close();
    }catch (Throwable e){e.printStackTrace();}
    return imageName.toString();
}