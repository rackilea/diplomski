public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main );

    MyClass work = new MyClass();
    work.doSomething();

}

public class MyClass{

    public void doSomething(){
        Log.d("tag", "yes sir!");
    }
}