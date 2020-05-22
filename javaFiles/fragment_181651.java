@Override
 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);

     if(condition){
         setContentView(R.layout.activity_1);
     } else {
         setContentView(R.layout.activity_2);
     }
 }