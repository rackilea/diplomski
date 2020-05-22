@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_ai, container, false);

       imageView=(ImageView)view.findViewById(R.id.savage);
       imageView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent = new Intent(getActivity(),postpg.class);
             startActivity(intent);
         }
        });

       return view;
    }