public class MainActivity extends AppCompatActivity {

        Point A, B, C, D;
        int i;
        TextView tv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tv = findViewById(R.id.tv);

             A = new Point();
            A.x = 1;
            A.y = 1;
            A.paths.put("B", 1);
            A.paths.put("C", 2);

            addition();

        }

        private void addition() {

             tv.setText(""+A.x);

        }

    }