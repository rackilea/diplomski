@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_chat);

    chatGroupName = getIntent().getStringExtra(CHAT_GROUP_NAME);
    userKey = getIntent().getStringExtra(USER_KEY);
    user = getIntent().getParcelableExtra(USER);

    jChatToolbar = (Toolbar) findViewById(R.id.allUSersToolBar);
    jChatMessageText = (EditText) findViewById(R.id.chatMessageText);
    jChatSendTextBtn = (ImageButton) findViewById(R.id.chatSendTextBtn);

    jChatSendTextBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendMessage();
        }
    });
}

private void sendMessage() {
    String userMessage = jChatMessageText.getText().toString();
    chatGroupRef = FirebaseDatabase.getInstance().getReference().child("Group Chats").child(chatGroupName);

    if (!TextUtils.isEmpty(userMessage)) {
        String newChatMessageKey = chatGroupRef.push().getKey();
        ChatMessage newChatMessage = new ChatMessage(userKey, user.getName(), userMessage);
        chatGroupRef.child(newChatMessageKey).setValue(newChatMessage);
    }
}