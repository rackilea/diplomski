public class class_name extends AppCompatActivity {
 public static final String MyPREFERENCES2 = "MyPrefs" ;
 SharedPreferences sharedpreferences2;
 public boolean isFirstRun;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_class_name);


    new Timer().schedule(new TimerTask() {
        public void run() {
            checkFirstRun();

        }
    }, 3000);




}
   public void checkFirstRun() {
    System.out.println("its in check first run");
    isFirstRun = getSharedPreferences("PREFERENCE2",  MODE_PRIVATE).getBoolean("isFirstRun", true);
    if (isFirstRun){
       startActivity(new Intent(class_name.this, new_activity1.class));

        getSharedPreferences("PREFERENCE2", MODE_PRIVATE)
                .edit()
                .putBoolean("isFirstRun", false)
                .commit();

    }
    else{
         startActivity(new Intent(class_name.this, new_activity2.class));

        }
     }
}