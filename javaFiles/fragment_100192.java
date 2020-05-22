private class MyManager {
    private SharedPreferencesManager manager;

    @Inject
    MyManager(SharedPreferencesManager manager){
          this.manager = manager;           
    } 
}