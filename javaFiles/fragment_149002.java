public class Globals extends Application {
    private static Globals instance;
    private List<Float> current = new ArrayList<>();

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }

    public float getCurrent() {
        return current.get(current.size()-1);
    }

    public void setCurrent(float someVariable) {
        this.current.add(someVariable);
    }

    public static Globals getInstance() {
        return instance;
    }

    public static Context getContext(){
       return instance;
    // or return instance.getApplicationContext();
   } 
}