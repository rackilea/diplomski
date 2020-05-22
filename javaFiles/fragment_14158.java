public class Home extends HeaderFooter 
{
        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
            ViewGroup.inflate(Home.this, R.layout.home, vg);
        }
}