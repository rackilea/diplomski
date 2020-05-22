public void onChildAdded(DataSnapshot dataSnapshot, String s) {
    Message message = dataSnapshot.getValue(Message.class);
    messageList.add(message);
    keyList.add(dataSnapshot.getKey());
    mAdapter.notifyDataSetChanged();
}