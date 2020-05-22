public class MainActivity extends Activity 
    {

        public Light myLight = new Light();

        Fan myFan = new Fan();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            myFan.breakDevice();

            myLight.breakDevice();  
      }    

    }