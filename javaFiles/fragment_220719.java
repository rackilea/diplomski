public class ChatMessagesActivity extends ApplicationDrawerLoader {

    HttpClient httpClient;
    ConsoleChatClient consoleChatClient;
    boolean mBound = false;

    private ChatListener chatListener = new ChatListener();

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, ConsoleChatClient.class);
        bindService(intent, mConnection, Context.BIND_IMPORTANT);
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            ConsoleChatClient.LocalBinder binder = (ConsoleChatClient.LocalBinder) service;
            consoleChatClient = binder.getService();
            mBound = true;
            onConsoleChatClientReady()
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        // Unbind from the service
        if (mBound) {
            unbindService(mConnection);
            mBound = false;

            if (conversationId != 0) {
                consoleChatClient.client.getChannel("/person/" + conversationId).unsubscribe();
            }

            if (groupAccountId != 0) {
                consoleChatClient.client.getChannel("/chat/" + conversationId).unsubscribe();
            }
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_messages);

        Intent intent = new Intent(this, ConsoleChatClient.class);
        startService(intent);


    }

    private void onConsoleChatReady(){
        httpClient = consoleChatClient.httpClient;
        if (conversationId != 0) {
        consoleChatClient.client.getChannel("/person/" + conversationId).subscribe(chatListener);
        }

        if (groupAccountId != 0) {
        consoleChatClient.client.getChannel("/chat/" + conversationId).subscribe(chatListener);
        }
    }
}