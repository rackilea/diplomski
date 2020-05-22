@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    context = this;
    String a="Secomd",b = "Activity";
    GenericCallback genericCallback = MainActivity.getHandler();
    genericCallback.doSomething(context,a,b);
    finish();
}