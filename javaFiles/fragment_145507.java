private void copyFiletoExternalStorage (int resourceId, String resourceName){
    String pathSDCard = Environment.getExternalStorageDirectory() + "/Android/data/" 
+ resourceName;
    try{
        InputStream in = getResources().openRawResource(resourceId);
        FileOutputStream out = null;
        out = new FileOutputStream(pathSDCard);
        byte[] buff = new byte[1024];
        int read = 0;
        try {
            while ((read = in.read(buff)) > 0) {
                out.write(buff, 0, read);
            }
        } finally {
            in.close();
            out.close();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

}