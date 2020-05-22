if (fileSize > 0) {
    currentProgress = ((progress += count) * 100 / fileSize);
    // Publish only on increments of 1%
    if (currentProgress >= previousProgress + 1) {
        this.publishProgress(currentProgress);
        previousProgress = currentProgress;
    }

}