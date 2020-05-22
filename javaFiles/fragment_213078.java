private void updateProgress(int counter) {
  WhateverActivity.this.runOnUiThread(new Runnable() {
    public void run() {
      progress.setProgress(counter);
    }
  });
}