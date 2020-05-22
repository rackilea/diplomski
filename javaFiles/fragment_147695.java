SwingWorker<Boolean, Void> loginWorker = new SwingWorker<Boolean, Void>() {
    protected Boolean doInBackground() {
        return login();
    }

    protected void done() {
        try {
            boolean loginSuccessful = get();
            if (loginSuccessful) {
                updateGUI();
            }
        }
        catch (Exception e) {
            displayErrorMessage(e);
        }
    }
};