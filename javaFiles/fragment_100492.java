Intent intent = getIntent();
String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
String[] messageArray = message.split("-");
int eventData = Integer.parseInt(messageArray[0]);
int sectorData = Integer.parseInt(messageArray[1]);
int minticketData = Integer.parseInt(messageArray[2]);
int maxticketData = Integer.parseInt(messageArray[3]);

protected void onCreate(Bundle savedInstanceState){
  ...
}