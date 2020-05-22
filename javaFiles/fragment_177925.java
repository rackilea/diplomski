public static void stop(MediaPlayer mediaPlayer) {
    if (mediaPlayer != null) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            resetRelease(mediaPlayer);
        } catch (Exception e) {
            Log.e(MediaPlayerUtil.class.getName(),
                    String.format("Failed to stop media player: %s", e));
        }
    }
}