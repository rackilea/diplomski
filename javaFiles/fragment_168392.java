void processStopRequest(boolean force, final boolean stopSelf) {
    if (mState == State.Playing || mState == State.Paused || force) {
        mState = State.Stopped;
        // let go of all resources...
        relaxResources(true);
        currentTrackNotification = null;
        giveUpAudioFocus();         

    }
}