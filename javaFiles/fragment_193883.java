mAudioManager =  (AudioManager) getSystemService(Context.AUDIO_SERVICE);
mReceiverComponent = new ComponentName(this,YourBroadcastReceiver.class);
...
mAudioManager.registerMediaButtonEventReceiver(mReceiverComponent);
...
// somewhere else
mAudioManager.unregisterMediaButtonEventReceiver(mReceiverComponent);