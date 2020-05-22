@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Intent intent = new Intent("pacman.intent.action.BROADCAST");
    intent.putExtra("message","Wake up.");
    sendBroadcast(intent);
}