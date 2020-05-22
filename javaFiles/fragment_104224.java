public class MainActivity extends Activity {

TextView tv;
Handler m_handler;
Runnable m_handlerTask ; 
int i=0;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    tv = (TextView) findViewById(R.id.textView1);
     m_handler = new Handler();
    m_handlerTask = new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            if(i<=100)
            {
            tv.setText(""+i);
             i++;
            }
            else
            {
                m_handler.removeCallbacks(m_handlerTask);
            }
            m_handler.postDelayed(m_handlerTask, 1000);
        }
    };
    m_handlerTask.run();  
   }
   }