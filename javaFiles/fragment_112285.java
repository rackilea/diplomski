private void notifyListeners() {
    int completedUploadCount = 0;
    List<TransferObserver> observers = new ArrayList<>(transferObservers.values());
    for (TransferObserver transferObserver : observers) {
        if (transferObserver.getState() == TransferState.COMPLETED) {
            completedUploadCount++;
        }
    }
    ...
}