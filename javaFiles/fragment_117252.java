@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_create_task, container, false);

    TextView endDateView = (TextView)rootView .findViewById(R.id.estimated_end_input);
    endDateView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("Date","I'm clicked");
        }
    });

 return rootView;

 }