public class MainActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            TextView tvData=(TextView)findViewById(R.id.tvSelectedData);

            String DBName="AndroidDB";
            String UserName="sa";
            String Password="ok";

            try {gaConnection con=new gaConnection();
                con.setConnection(DBName,UserName,Password);
                tvData.setText(con.showResult());
            } catch (Exception e) {
                e.printStackTrace();
                tvData.setText(e.getMessage());
            }

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

    }