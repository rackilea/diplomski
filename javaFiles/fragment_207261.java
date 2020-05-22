class PhotoStorage { 
    // hidding default constructor
    private PhotoStorage () {};

    // creating your own constructor but private!!!
    private PhotoStorage(Context appContext){
        mSerializer = new PhotoJSONer(appContext, PHOTOS_DATABASE);
        try{
            mPhotos = mSerializer.loadPhotos();
        }catch(Exception e){
            mPhotos = new ArrayList<Photo>();
        }
    }

    //Singleton enforcement
    public synchronized static PhotoStorage get(Context c){
        if(sPhotoStorage == null){
            sPhotoStorage = new PhotoStorage(c.getApplicationContext());
        }
        return sPhotoStorage;
    }
}