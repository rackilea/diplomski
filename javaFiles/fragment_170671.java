@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_page, container, false);

        final Textview textview = view.findViewById(R.id.date_apr);
        textview.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
              Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
              startActivity(intent);
           }
          });
        return view;
    }