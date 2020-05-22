private void log(final String message) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            infoTextArea.append(LogUtils.formatLogMessage(message));
        }
    });
}