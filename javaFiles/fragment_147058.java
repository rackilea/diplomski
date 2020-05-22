public class App2Activity extends Activity {

        Button button;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main2);


           button = (Button) findViewById(R.id.button2);

            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {

                    Intent intent = new Intent(App2Activity.this, App3Activity.class);
                                startActivity(intent);   

                }

            });

        }


    }