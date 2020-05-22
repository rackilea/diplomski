public class SingularBitmapFactory { 
    private HashMap <String, WeakReference<Bitmap>> cache = new HashMap<String, WeakReference<Bitmap>>();

    public Bitmap getBitmap(String key) {
        Bitmap image = null;
        WeakReference<Bitmap> ref = cache.get(key);
        if(ref != null) {
            image = ref.get();
        }
        if(image == null) {
            // Load image here ... 
            cache.put(key, new WeakReference<Bitmap>(image));
        }
        return image;   
    }
}