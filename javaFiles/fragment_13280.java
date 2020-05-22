public class ServiceActivity extends Activity {
    Button play;
    int button_status=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        play=(Button)findViewById(R.id.button1);

        play.setOnClickListener(new OnClickListener() {         
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                if(button_status == 1)//play the service
                {
                button_status=0;
                Intent i=new Intent(ServiceActivity.this,Playing.class);
                startService(i);
                }
                else//stop the service
                {
                button_status=1;
                Intent i=new Intent(ServiceActivity.this,Playing.class);
                stopService(i); 
                } 
        });

    }  
}