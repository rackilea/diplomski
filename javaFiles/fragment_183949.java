public class MainActivity extends Activity {

        private boolean goBack = false;           


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);



                Button sobre = (Button) findViewById(R.id.button1);
                  sobre.setOnClickListener(new OnClickListener() {
                   public void onClick(View v) {
                           goBack = true;
                           setContentView(R.layout.janela2);
                   }
                   });


        }

        @Override
        public void onBackPressed() {
        //If you have switched to R.layout.janela2 then go back
        if (goBack){
            setContentView(R.layout.activity_main);
            goBack = false;
            return;
            }
        //else do default action
        super.onBackPressed();
        }
}