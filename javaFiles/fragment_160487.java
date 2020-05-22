class DownloadListener implements PropertyChangeListener {
    private DownloadPanel downloadPanel;

    public DownloadListener(DownloadPanel downloadPanel) {
        this.downloadPanel = downloadPanel;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
            int value = (int) evt.getNewValue();
            downloadPanel.setPercentDownload(value);
        } else if ("state".equals(evt.getPropertyName())) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                Download download = (Download) evt.getSource();
                try {
                    download.get();
                } catch (InterruptedException | ExecutionException e) {
                    // TODO: handle exceptions here
                    e.printStackTrace();
                }
            }
        }
    }
}