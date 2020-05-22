final int progress = (int)Math.round(
    100.0 * ((double)symbolsWritten / (double)totalSymbols)
);

EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        bar.setValue(progress);
    }
});