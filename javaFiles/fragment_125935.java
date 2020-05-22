public class MySingleton {
    private static MySingleton _instance;
    private  ArrayList<SomeObject> myList;

    private MySingleton() {
        myList = new ArrayList<SomeObject>();
    }

    public static synchronized MySingleton getInstance() {
        if (_instance==null) {
            _instance = new MySingleton();
        }
        return _instance;
    }

    public ArrayList<SomeObject> getMyList(){
        return myList;
    }

}