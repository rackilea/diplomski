protected void updateProgress(int value) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            InnerProgress.this.jpb.setValue(value);
        }
    });
}