DatabaseReference requestReference = FirebaseDatabase.getInstance().getReference().child("Requests");

 listAdapterOptions = new FirebaseListOptions.Builder<Requests>()
   .setLayout(android.R.layout.simple_list_item_1)
   .setQuery(requestReference, Requests.class)
   .build();

 listAdapter = new FirebaseListAdapter<Requests>(listAdapterOptions) {
    @Override
  protected void populateView(View v, RideRequests requests, int position) {
     ((TextView)v.findViewById(android.R.id.text1)).setText(requests.getID());
   }
 };
ListView.setAdapter(listAdapter);