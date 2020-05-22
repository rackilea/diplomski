@Override
 public View onCreateView(LayoutInflater inflater, ViewGroup container, 
     Bundle savedInstanceState) {
     View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);
     rootView.findViewById(R.id.add_drink).setOnClickListener(new OnClickListener() {  
         @Override
         public void onClick(View v) {
            Log.d("tag","hello");
         }
     });
     return rootView;
 }