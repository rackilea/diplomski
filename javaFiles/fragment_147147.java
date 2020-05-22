int vlcRequestCode = 42;  Uri uri =
Uri.parse("file:///storage/emulated/0/Movies/KUNG FURY Official
Movie.mp4");  Intent vlcIntent = new Intent(Intent.ACTION_VIEW); 
vlcIntent.setPackage("org.videolan.vlc"); 
vlcIntent.setDataAndTypeAndNormalize(uri, "video/*"); 
vlcIntent.putExtra("title", "Kung Fury"); 
vlcIntent.putExtra("from_start", false); 
vlcIntent.putExtra("position", 90000l); 
vlcIntent.putExtra("subtitles_location",
"/sdcard/Movies/Fifty-Fifty.srt");  startActivityForResult(vlcIntent,
vlcRequestCode);