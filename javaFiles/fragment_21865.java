audioTrack.setPositionNotificationPeriod(2205);
audioTrack.setPlaybackPositionUpdateListener(this);

...

public void onPeriodicNotification(AudioTrack track) {
    int pos = track.getNotificationMarkerPosition();
    short[] slice = Array.copy(_data, pos, _sliceSize) // pseudo-code
    // render the slice to the view
}