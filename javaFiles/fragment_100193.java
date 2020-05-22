private class MyActivity extends Activity {
    @Inject
    MyManager manager;

    public void onCreate(Bundle savedState){
        component.inject(this);  
    } 
}