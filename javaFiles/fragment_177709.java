final ServerReplyHandler currentHandler = ...
final Object currentReply = ...

SwingUtilities.invokeAndWait(new Runnable() {
    public void run() {

        currentHandler.handleReply(currentReply);

    }
});