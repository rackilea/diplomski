String CUSTOM_ACTION = "com.example.YOUR_ACTION";

 Intent i = new Intent();
 i.setAction(CUSTOM_ACTION)
 intent.putExtra(ITEM_KEY,item);
 context.sendBroadcast(intent);