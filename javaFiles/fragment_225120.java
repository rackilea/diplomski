public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
    View rootview = inflater.inflate(R.layout.xml_you_want_to_inflate, container,false);        
    // Now call rootview and the onclick fuction, presumably for a list or button
    rootview.findViewById(R.id.your_button/list_id_here).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        // Do stuff.
        }
    });