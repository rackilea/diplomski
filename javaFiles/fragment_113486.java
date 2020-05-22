public class aktivnost extends Activity {
    MyClass[] myclass = new MyClass[5];

    void myMethod()
    {
        //Error
        myclass[0] = new MyClass(); 
        myclass[0].number = 1;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        myMethod();
        setContentView(new Panel(this));
    }
...other required methods
}