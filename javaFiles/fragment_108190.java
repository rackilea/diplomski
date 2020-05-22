@Override 
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_detail, container, false);

        RelativeLayout rl = (RelativeLayout)view.findViewById(R.id.home_top_layout);

         rl.setOnClickListener(new View.OnClickListener()
         {
            public void onClick(View v) {
            startActivity(new Intent(getActivity(),  OrganizationActivity.class).putExtra("User",user));
          }
        });
        return view;
    }