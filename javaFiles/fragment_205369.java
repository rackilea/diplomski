public class IncomingMessageHandler extends MessageInbound {

    private WsOutbound myoutbound;
    public IncomingMessageHandler() {

    }

    @Override
    public void onOpen(WsOutbound outbound) {
        logger.info("Open Client.");
        this.myoutbound = outbound;
    }

    @Override
    public void onClose(int status) {
        logger.info("Close Client.");           
    }

    /**
     * Called when received plain Text Message
     */
    @Override
    public void onTextMessage(CharBuffer cb) throws IOException {

    }

    /**
     * We can use this method to pass image binary data, eventually !
     */
    @Override
    public void onBinaryMessage(ByteBuffer bb) throws IOException {

    }

    public synchronized void sendTextMessage(String message) {
        try {
            CharBuffer buffer = CharBuffer.wrap(message);
            this.getMyoutbound().writeTextMessage(buffer);
            this.getMyoutbound().flush();

        } catch (IOException e) {   
        }
    }

    /**
     * Set timeout in milliseconds, -1 means never
     */
    @Override
    public int getReadTimeout() {
        return -1;
    }

    public WsOutbound getMyoutbound() {
        return myoutbound;
    }
    public void setMyoutbound(WsOutbound myoutbound) {
        this.myoutbound = myoutbound;
    }
}