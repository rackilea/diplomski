public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blackwidow_fragment, container, false);

        Button b = (Button)view.findViewById(R.id.your_button_id);
        b.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                 // do something when clicked...
              }
        });

        return view;
    }