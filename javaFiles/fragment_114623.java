if (files != null) {
    for (final Html5File html5File : files) {
        final String fileName = html5File.getFileName();

        if (html5File.getFileSize() > FILE_SIZE_LIMIT) {
            Notification
                .show("File rejected. Max 2Mb files are accepted by Sampler",
                                          Notification.Type.WARNING_MESSAGE);
        } else {

            final ByteArrayOutputStream bas = new ByteArrayOutputStream();
            final StreamVariable streamVariable = new StreamVariable() {

                 @Override
                 public OutputStream getOutputStream() {
                      return bas;
                 }

                 @Override
                 public boolean listenProgress() {
                      return false;
                 }

                 @Override
                 public void onProgress(
                      final StreamingProgressEvent event) {
                 }

                 @Override
                 public void streamingStarted(
                      final StreamingStartEvent event) {
                 }

                 @Override
                 public void streamingFinished(
                      final StreamingEndEvent event) {
                      progress.setVisible(false);
                      showFile(fileName, html5File.getType(), bas);
                 }

                 @Override
                 public void streamingFailed(
                      final StreamingErrorEvent event) {
                      progress.setVisible(false);
                 }

                 @Override
                 public boolean isInterrupted() {
                      return false;
                 }
             };
             html5File.setStreamVariable(streamVariable);
             progress.setVisible(true);
        }
    }

} else {
     final String text = tr.getText();
     if (text != null) {
         showText(text);
     }
}