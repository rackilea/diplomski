public View onCreateView(LayoutInflater inflater,
         ViewGroup containerObject,
         Bundle savedInstanceState){
         //here is your arguments
         Bundle bundle= getArguments(); 

        View view =  inflater.inflate(R.layout.your_fragment_layout, container, false);
        btnStart = view.findViewById(R.id.id_of_your_button);
        if(bundle!=null){
           if(bundle.getBoolean("BUTTON_VISIBILITY", false)){
              btnStart.setVisibility(View.VISIBLE);
           } 
        }
     return view;
     }