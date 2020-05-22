long startTime;
private final int REFRESH_RATE = 25;

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.orderwaiting); 
setupVariables();     

}

private void setupVariables() { 

   SharedPreferences sData14 = getSharedPreferences(filename, 0);
   startTime = sData14.getLong("sharedString14", -1);

   if(startTime == -1){
       //startTime not previously saved
       starttime = System.currentTimeMillis();           

       SharedPreferences.Editor editor = sData14.edit();      
       editor.putLong("sharedString14", starttime);                       
       editor.commit();
   }

    mHandler.removeCallbacks(startTimer);
    mHandler.postDelayed(startTimer, 0);
}