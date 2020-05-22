public View onCreateView(LayoutInflater inflater, ViewGroup containerObject, Bundle savedInstanceState){
                return  inflater.inflate(R.layout.your_fragment_layout, container, false); 
             }

   public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle= getArguments(); 
        btnStart = view.findViewById(R.id.id_of_your_button);
            if(bundle!=null){
               if(bundle.getBoolean("BUTTON_VISIBILITY", false)){
                  btnStart.setVisibility(View.VISIBLE);
               } 
            }
    }