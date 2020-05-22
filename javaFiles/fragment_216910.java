public class MainActivity extends AppCompatActivity {
        Button btn;
        TextView txt;

        protected int a = 1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btn = (Button) findViewById(R.id.button);
            txt = (TextView) findViewById(R.id.textView);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   a++;
                   display(a);
                }
            });

        }

        public void display(int n) {
            txt.setText("" + n);
            //txt.setText(n);
        }
}