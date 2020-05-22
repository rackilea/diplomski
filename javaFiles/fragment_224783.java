private void muteAudio() {      
    audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    audio.setStreamMute(AudioManager.STREAM_NOTIFICATION,   true);
    audio.setStreamMute(AudioManager.STREAM_ALARM,          true);
    audio.setStreamMute(AudioManager.STREAM_MUSIC,          true);
    audio.setStreamMute(AudioManager.STREAM_RING,           true);
    audio.setStreamMute(AudioManager.STREAM_SYSTEM,         true);

    isAudioMuted = true;
}

private void unmuteAudio() {
    audio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
    audio.setStreamMute(AudioManager.STREAM_NOTIFICATION,   false);
    audio.setStreamMute(AudioManager.STREAM_ALARM,          false);
    audio.setStreamMute(AudioManager.STREAM_MUSIC,          false);
    audio.setStreamMute(AudioManager.STREAM_RING,           false);
    audio.setStreamMute(AudioManager.STREAM_SYSTEM,         false);

    isAudioMuted = false;
}