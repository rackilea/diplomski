ComponentName mediaButtonReceiver =
  new ComponentName(context, YourBroadcastReceiver.class);
MediaSessionCompat mediaSession = 
  new MediaSessionCompat(context,
  tag, // Debugging tag, any string
  mediaButtonReceiver,
  null);
mediaSession.setFlags(
  MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS | 
  MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);
mediaSession.setCallback(this); // a MediaSessionCompat.Callback

// This is what enables media buttons and should be called
// Immediately after getting audio focus
mediaSession.setActive(true);