@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);
    Button mibtn = (Button)rootView.findViewById(R.id.button);

    mibtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
         Toast.makeText(getApplicationContext(),"Apretado", Toast.LENGTH_LONG).show();
        }
});

    return rootView;
}