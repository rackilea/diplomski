public class MyObject {

    private transient Context context;

    // ... other fields here

    public MyObject() {
    }

    public void setContext(Context context) {
        this.context = context;
    }

}