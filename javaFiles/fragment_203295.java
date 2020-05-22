public class MyCache {

private String DiretoryName;

public void OpenOrCreateCache(Context _context, String _directoryName){
    File file = new File(_context.getCacheDir().getAbsolutePath() + "/" + _directoryName);
    if(!file.exists()){
        file.mkdir();
    }
    DiretoryName = file.getAbsolutePath();
}

public void SaveBitmap(String fileName, Bitmap bmp){
    try {
        File file = new File(DiretoryName+ "/" + fileName);
        if(file.exists()){
            file.delete();
        }
        FileOutputStream Filestream = new FileOutputStream(DiretoryName + "/" + fileName);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        Filestream.write(byteArray);
        Filestream.close();
        bmp.recycle();
    }
    catch (Exception e){
        e.printStackTrace();
    }
}

public Bitmap OpenBitmap(String name){
    try {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        File file = new File(DiretoryName+ "/" + name);
        if(file.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(DiretoryName+ "/" + name, options);
            return bitmap;
        }
        else{
            return null;
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
    return null;
}

public void CleanCacheBitMap(){
    File file = new File(Diretorio);
    if(file.exists()){
        file.delete();
    }
}