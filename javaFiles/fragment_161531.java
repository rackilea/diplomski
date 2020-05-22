Intent broadcastIntent = new Intent();
broadcastIntent.setAction(MainActivity.NOTIFY_ACTIVITY_ACTION );
broadcastIntent.putExtra("addtional_param", 1);
broadcastIntent.putExtra("addtional_param2", 2); //etc

sendBroadcast(broadcastIntent);