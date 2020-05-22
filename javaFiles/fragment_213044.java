private Drawable getBitmap(String url) 
{
    String filename=URLEncoder.encode(url);
    File f= new File(cacheDir, filename);

    try {                        
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        InputStream is = conn.getInputStream();
        OutputStream os = new FileOutputStream(f);
        CopyStream(is, os);
        os.close();            

        Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(f));            
        return new BitmapDrawable(bitmap);
    } catch (Exception ex){
       ex.printStackTrace();
       return null;
    }
}