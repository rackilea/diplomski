add1.setTransferHandler(new TransferHandler("text") {
    @Override
    public int getSourceActions(JComponent c) {
        return COPY | MOVE;
    }
});