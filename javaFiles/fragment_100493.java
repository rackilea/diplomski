Intent intent;
String message ;
String[] messageArray;
int eventData;
int sectorData;
int minticketData;
int maxticketData;

protected void onCreate(Bundle savedInstanceState) {
  ...

  intent = getIntent();
  message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
  messageArray = message.split("-");
  eventData = Integer.parseInt(messageArray[0]);
  sectorData = Integer.parseInt(messageArray[1]);
  minticketData = Integer.parseInt(messageArray[2]);
  maxticketData = Integer.parseInt(messageArray[3]);
}