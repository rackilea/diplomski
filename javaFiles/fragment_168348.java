public class A extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);  
    SharedPreferences settings=getSharedPreferences("prefs",0);
    boolean firstRun=settings.getBoolean("firstRun",false);
    if(firstRun==false)//if running for first time
      {
        SharedPreferences.Editor editor=settings.edit();
        editor.putBoolean("firstRun",true);
        editor.commit();
       //execute your code for first time
    }
    else
    {
        Intent a=new Intent(A.this,B.class); 
        startActivity(a);
        finish();
    }
   }

}