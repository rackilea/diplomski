if (mState == State.Playing) {
        // Pause media player and cancel the 'foreground service' state.
        mState = State.Paused;
        mPlayer.pause();
        dispatchBroadcastEvent(ServiceConstants.EVENT_AUDIO_PAUSE);//notify broadcast receivers
        relaxResources(false); // while paused, we always retain the mp and notification