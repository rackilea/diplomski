@SuppressWarnings("serial")
class DownloadPanel extends JPanel {
    private static final String PROGRESS_FORMAT = "%03d%%";
    private JProgressBar jpb = new JProgressBar(0, 100);
    private JLabel downloadedSizeLabel = new JLabel(String.format(PROGRESS_FORMAT, 0));
    private DownLoadAction downLoadAction = new DownLoadAction();

    public DownloadPanel() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Download Progress:"));
        topPanel.add(downloadedSizeLabel);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton(downLoadAction));

        setLayout(new BorderLayout());        
        add(topPanel, BorderLayout.PAGE_START);
        add(jpb);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public void setPercentDownload(int value) {
        downloadedSizeLabel.setText(String.format(PROGRESS_FORMAT, value));
        jpb.setValue(value);
        if (value == 100) {
            downLoadAction.setEnabled(true);
        }
    }

    private class DownLoadAction extends AbstractAction {
        public DownLoadAction() {
            super("Download");
            putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setEnabled(false);
            setPercentDownload(0);
            Download download = new Download();
            DownloadListener listener = new DownloadListener(DownloadPanel.this);
            download.addPropertyChangeListener(listener);
            download.execute();
        }
    }
}