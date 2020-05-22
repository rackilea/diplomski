public interface SeekListener {
    void onSeekTo(boolean ffwdrwd);
}

@Override
public void seekTo(int pos) {
    boolean ffwdrwd = false;
    if (super.getCurrentPosition() <= pos)
        ffwdrwd = false;
    else
        ffwdrwd = true;
    if (mListener != null) {
        mListener.onSeekTo(ffwdrwd);
    }
    super.seekTo(pos);
}