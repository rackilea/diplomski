private Button button;         
 @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
    Bundle savedInstanceState) {
    View view  = inflater.inflate(R.layout.fragment_bk, container, false);
    setViewRefs(view);
    return view;
}


private void setViewRefs(View view){
     button = (Button)view.findViewById(R.id.button);

  }