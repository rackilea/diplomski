void processNextRequest(final boolean isSkipping) {
    processStopRequest(true, false); // THIS IS IMPORTANT, WE RELEASE THE MP HERE
    mState = State.Retrieving;
    dispatchBroadcastEvent(ServiceConstants.EVENT_TRACK_INFO_LOAD_START);
    // snipped but here you retrieve your next track and when it's ready…
    // you just processPlayRequest() and "start from scratch"