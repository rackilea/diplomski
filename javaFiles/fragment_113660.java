final List<String> req = new ArrayList<>();
final ChallengeSuggestionAdapter adapter = new ChallengeSuggestionAdapter(getActivity(), req);
recyclerView.setAdapter(adapter);

databaseReference.child("user").addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
       req.clear();
       for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
            String requests = postSnapshot.getValue(String.class);
            req.add(requests);
        }
        recyclerView.notifyDataSetChanged();
    }
});