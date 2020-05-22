//for play/pause toggle
Intent i = new Intent("com.android.music.musicservicecommand");
i.putExtra("command", "togglepause");
MainActivity.this.sendBroadcast(i);

//for next
Intent i = new Intent("com.android.music.musicservicecommand");
i.putExtra("command", "next");
MainActivity.this.sendBroadcast(i);

//for prev
Intent i = new Intent("com.android.music.musicservicecommand");
i.putExtra("command", "previous");
MainActivity.this.sendBroadcast(i);

//to change volume
audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, *value*, AudioManager.FLAG_SHOW_UI);