public class MainActivity extends Activity 
        {
            Button start;
            TextView time;
            Handler m_handler;
            Runnable m_handlerTask ; 
            int timeleft=100;

            protected void onCreate(Bundle savedInstanceState) 
            {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                start = (Button) findViewById(R.id.button1);
                time = (TextView)findViewById(R.id.textView1);

                start.setOnClickListener(new View.OnClickListener() 
                {
                    public void onClick(View arg0) 
                    {

                        m_handler = new Handler(); 
                        m_handlerTask = new Runnable() 
                        { 
                        @Override
                        public void run() {
                        if(timeleft>=0)
                        {  
                             // do stuff
                             Log.i("timeleft",""+timeleft);
                             time.setText(String.valueOf(timeleft));
                             timeleft--; 

                        }      
                        else
                        {
                          m_handler.removeCallbacks(m_handlerTask); // cancel run
                        } 
                          m_handler.postDelayed(m_handlerTask, 1000); 
                         }
                         };
                         m_handlerTask.run();   

                    }
                });

            }
 }