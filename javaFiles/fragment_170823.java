this.setTransferHandler(new TransferHandler("text") {
    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
        if (action == MOVE){
            ((JLabel) source).setText("");
        }
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY | MOVE;
    }
});