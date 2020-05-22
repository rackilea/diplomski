public class NoteDataStoreAndroid implements NoteDataStore{

    public boolean deleteNote(long noteId){
        /*
         * Android-specific database code
         */
    }

    /* ... similarly, other methods */
}


public class AndroidCoreApp{

    public void doBusinessLogic(){
        BusinessLogicLayer businessLogic = new BusinessLogicLayer(new NoteDataStoreAndroid());
        businessLogic.startBusinessLogic();
    }
}

public class BusinessLogicLayer {

    private NoteDataStore mDataStore;
    public BusinessLogicLayer(NoteDataStore dataStore){
        this.mDataStore = dataStore;

        //Do something useful with mDataStore
    }

    public void startBusinessLogic(){
        //Do something useful with mDataStore
    }

}