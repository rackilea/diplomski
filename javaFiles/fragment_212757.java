@Override
View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
  View view = // inflate view from layout resource
  list_item = getActivity().findViewById(R.id.list_item); // Get toolbar item
  list_item.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      // Do you click stuff
    }
  }
}