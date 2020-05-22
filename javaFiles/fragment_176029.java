private void displayChatMessage() {
    ListView listMessage = (ListView) findViewById(R.id.list_of_message);
    adapter = new FirebaseListAdapter<ChatMsg>(options) {
        ...
    };
    listMessage.setAdapter(adapter);
    adapter.startListening();
}