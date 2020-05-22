public void startCUBMonitoring() {
    if (autoEventThread == null) {
        Log.d(LOG_TAG, "startCUBMonitoring");
        addUIEvent("CUB MONITORING STARTED", "CUB_connexion");
        SessionRepository sessionRepository =
                ElabsheetApplication.getInstance().getSessionRepository();

        // Creation of the task
        AutoEventTask autoEventTask = new AutoEventTask(
                this,
                sessionRepository,
                sessionRepository.getCUBConfig()
        );
        autoEventThread = new Thread(autoEventTask);
        autoEventThread.start();
    }

}

public void stopCUBMonitoring() {
    if (autoEventThread != null) {
        Log.d(LOG_TAG, "stopCUBMonitoring");
        addUIEvent("CUB MONITORING STOPPED", "CUB_connexion");
        autoEventThread.interrupt();
        autoEventThread = null;
    }
}