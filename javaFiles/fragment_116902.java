public static synchronized Buffer getInstance(){
    if(instance == null){
        instance = new Buffer();
    }
    return instance;
}