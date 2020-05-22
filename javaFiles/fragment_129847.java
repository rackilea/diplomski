if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        mMediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build());
} else {
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
}