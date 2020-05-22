public class MainActivity extends ActionBarActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new CalculatorFragment())
                    .commit();
        }
    }


     /**
         * A placeholder fragment containing a simple view.
         */
    public static class CalculatorFragment extends Fragment  implements OnClickListener {

        private TextView mCalculatorDisplay;

        public CalculatorFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);


            mCalculatorDisplay = (TextView) rootView.findViewById(R.id.textView);

            rootView.findViewById(R.id.AC).setOnClickListener(this);
            rootView.findViewById(R.id.plusminus).setOnClickListener(this);
            rootView.findViewById(R.id.percent).setOnClickListener(this);
            rootView.findViewById(R.id.nine).setOnClickListener(this);
            rootView.findViewById(R.id.eight).setOnClickListener(this);
            rootView.findViewById(R.id.seven).setOnClickListener(this);
            rootView.findViewById(R.id.six).setOnClickListener(this);
            rootView.findViewById(R.id.five).setOnClickListener(this);
            rootView.findViewById(R.id.four).setOnClickListener(this);
            rootView.findViewById(R.id.three).setOnClickListener(this);
            rootView.findViewById(R.id.two).setOnClickListener(this);
            rootView.findViewById(R.id.one).setOnClickListener(this);
            rootView.findViewById(R.id.zero).setOnClickListener(this);
            rootView.findViewById(R.id.div).setOnClickListener(this);
            rootView.findViewById(R.id.mult).setOnClickListener(this);
            rootView.findViewById(R.id.plus).setOnClickListener(this);
            rootView.findViewById(R.id.minus).setOnClickListener(this);
            rootView.findViewById(R.id.dec).setOnClickListener(this);
            rootView.findViewById(R.id.equal).setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View v) {

            String buttonPressed = ((Button )v).getText().toString();
            mCalculatorDisplay.setText(buttonPressed);
        }
    }
}