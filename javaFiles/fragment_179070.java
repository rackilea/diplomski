public class MySingleton {
    private static MySingleton instance;
    private MySingleton(){
        //constructor here
    }
    public static MySingleton getInstance(){
        if(instance==null){
            instance = new MySingleton();
        }
        return instance;
    }
}