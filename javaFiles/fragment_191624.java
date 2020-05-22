private OnClickListener mClickListener = new OnClickListener() {

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
        case R.id.prev_button:
            if(mBound) {
                mRCService.sendPreviousKey();
            }
            break;
        case R.id.next_button:
            if(mBound) {
                mRCService.sendNextKey();
            }
            break;
        case R.id.play_pause_button:
            if(mBound) {
                if(mIsPlaying) {
                    mRCService.sendPauseKey();
                    mIsPlaying = false;
                } else {
                    mRCService.sendPlayKey();
                    mIsPlaying = true;
                }
            }
            break;
        }
    }
};