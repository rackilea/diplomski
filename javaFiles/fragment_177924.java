public static void pause(MediaPlayer mediaPlayer) {
    if (mediaPlayer != null) {
        try {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        } catch (Exception e) {
            Log.w(MediaPlayerUtil.class.getName(),
                    String.format("Failed to stop media player: %s", e));
        }
    }
}