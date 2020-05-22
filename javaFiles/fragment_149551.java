public class MainActivity extends AppCompatActivity
{

Button btnStopService;

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnStopService = findViewById(R.id.btnStopService);

    //get FirebaseToken
    getToken();

    //start Service
    startService();



    btnStopService.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MyService.class);
            stopService(intent);
        }
    });

}


private void getToken()
{
    FirebaseId firebaseId=new FirebaseId();
    String token_firebase=firebaseId.getFireBaseToken();
}


private void startService()
{

    Intent myIntent = new Intent(this, MyService.class);
    PendingIntent pendingIntent = PendingIntent.getService(this, 0, myIntent, 0);
    Log.e("TAG", "++++++++++222222++++++++");
    AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
    Calendar calendar = Calendar.getInstance();
    // calendar.setTimeInMillis(System.currentTimeMillis());
    //calendar.add(Calendar.SECOND, 10);
    if (alarmManager != null) {
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    Toast.makeText(this, "Start Alarm", Toast.LENGTH_LONG).show();

}

private void s()
{
    Intent intent = new Intent(this, MyService.class);
    startService(intent);
}}