/**
 * Releases resources used by the service for playback. This includes the "foreground service"
 * status and notification, the wake locks and possibly the MediaPlayer.
 *
 * @param releaseMediaPlayer Indicates whether the Media Player should also be released or not
 */
void relaxResources(boolean releaseMediaPlayer) {
    stopForeground(true);
    stopMonitoringPlaybackProgress();
    // stop and release the Media Player, if it's available
    if (releaseMediaPlayer && mPlayer != null) {
        mPlayer.reset();
        mPlayer.release();
        mPlayer = null;
    }
    // we can also release the Wifi lock, if we're holding it
    if (mWifiLock.isHeld()) {
        mWifiLock.release();
    }
}