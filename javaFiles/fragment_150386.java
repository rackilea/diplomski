public void onChildRemoved(DataSnapshot dataSnapshot) {
    int index = keyList.indexOf(dataSnapshot.getKey());
    messageList.remove(index);
    keyList.remove(index);
    mAdapter.notifyDataSetChanged();
}