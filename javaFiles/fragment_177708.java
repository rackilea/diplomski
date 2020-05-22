showWaitMessage();

Communications.callServer(myInputs, new ServerReplyHandler() {
    public void handleReply(Object myOutputs) {

        hideWaitMessage();
        // do something with myOutputs...

    }
});