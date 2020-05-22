private void updateContent()
{
    DownloadButton.setEnabled(false);
    SaveLocationButton.setEnabled(false);
    UpdateText.setText("Update to Version " + ServerVersionNumber + "...");
    UpdateText.setForeground(new Color(200, 150, 0, 255));
    ProgressText.setText("(1/2) Files will be downloaded");
    ProgressText.setForeground(new Color(200, 150, 0, 255));
    LoadingBar.setStringPainted(true);

    new Thread() {
        public void run() {
            for(int i = 1; i < (ServerVersionNumber - LocalVersionNumber + 1); i++)
            {
                // the rest
            }
        }
    }.start();
}