/**
 * Starts playing the next song.
 */
void beginPlaying(Track track) {
    mState = State.Stopped;
    relaxResources(false); // release everything except MediaPlayer
    try {
        if (track != null) {
            createMediaPlayerIfNeeded();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.setDataSource(track.audioUrl);
        } else {
            processStopRequest(true, false); // stop everything! 
            return;
        }
        mState = State.Preparing;
        setUpAsForeground(); //service

        /* STRIPPED ALL CODE FROM REMOTECONTROLCLIENT, AS IT ADDS A LOT OF NOISE :) */

        // starts preparing the media player in the background. When it's done, it will call
        // our OnPreparedListener (that is, the onPrepared() method on this class, since we set
        // the listener to 'this').
        // Until the media player is prepared, we *cannot* call start() on it!
        mPlayer.prepareAsync();
        // We are streaming from the internet, we want to hold a Wifi lock, which prevents
        // the Wifi radio from going to sleep while the song is playing.
        if (!mWifiLock.isHeld()) {
            mWifiLock.acquire();
        }

    } catch (IOException ex) {
        Log.e("MusicService", "IOException playing next song: " + ex.getMessage());
        ex.printStackTrace();
    }
}