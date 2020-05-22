public void onCreate(Bundle savedInstanceState) {      
 super.onCreate(savedInstanceState);

 Button button = null;

//YOU NEED TO INITIALIZE YOUR BUTTON HERE, YOUR BUTTON IS NULL
try {
    Drawable icon;
    icon = getPackageManager().getApplicationIcon("com.drdo.s.a.m.s");
    button.setBackground(icon);
} catch (NameNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

        Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage("com.drdo.s.a.m.s");        
        startActivity(LaunchIntent);     

        }
    });

  }