FirebaseListOptions<Chat> options = new FirebaseListOptions.Builder<Chat>()
        .setQuery(query, Chat.class)
        .build();

FirebaseListAdapter<Chat> adapter = new FirebaseListAdapter<Chat>(options) {
    @Override
    protected void populateView(View v, Chat model, int position) {
        // Bind the Chat to the view
        // ...
    }
};