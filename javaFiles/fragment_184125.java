public class MyActivity extends AppCompatActivity
{
    public void myFunction() {/* ... */}
}

public class MyClass
{
    MyActivity activity;

    //This could be the constructor
    public void someFunction(MyActivity gActivity)
    {
        activity = gActivity;
    }

    public void anotherFunction()
    {
        //From activity you can get everything you want like context
        //resources and anything else
        activity.myFunction();
    }
}