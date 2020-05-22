public void onChildAdded(DataSnapshot dataSnapshot, String s) {
    for(DataSnapshot dsp : dataSnapshot.getChildren()){
        String value = dataSnapshot.getValue().toString();
        list.add(String.valueOf(dsp.getValue()));
        listKey.add(dsp.getKey());
    }
    adapter.notifyDataSetChanged();
}