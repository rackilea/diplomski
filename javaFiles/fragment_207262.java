//Singleton enforcement
public synchronized static PhotoStorage get(Context c){
    if(sPhotoStorage == null){
        synchronized(PhotoStorage.class) {
            if(sPhotoStorage == null) {
                sPhotoStorage = new PhotoStorage(c.getApplicationContext());
            }
        }
    }
}