public void switch() {
    RelativeLayout chatsLayout = (RelativeLayout)findViewById(R.id.chatsLayout);
    RelativeLayout chats = (RelativeLayout)findViewById(R.id.chats);
    chats.setVisibility(View.GONE);

    RelativeLayout noChats = (RelativeLayout)findViewById(R.id.noChats);
    noChats.setVisibility(View.GONE);
}