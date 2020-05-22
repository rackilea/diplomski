mAdapter = new FirebaseListAdapter<ChatMessage>(this, ChatMessage.class, android.R.layout.two_line_list_item, ref) {
    @Override
    protected void populateView(View view, ChatMessage chatMessage) {
        ((TextView)view.findViewById(android.R.id.text1)).setText(chatMessage.getName());
        ((TextView)view.findViewById(android.R.id.text2)).setText(chatMessage.getMessage());

    }
};
messagesView.setListAdapter(mAdapter);