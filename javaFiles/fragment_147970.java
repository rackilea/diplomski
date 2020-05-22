public void actionPerformed(ActionEvent ae) {
    new TaskWorker().execute();
    button.setIcon(loadingIcon); //Shows loading. Maybe on button, maybe somewhere else.
    return;
}

private class TaskWorker extends SwingWorker<Void, T> {
    public Void doInBackground() {
        //Do your task in the background here
    }
    protected void done() {
        try {
            get();
            button.setIcon(doneIcon);
        catch (<relevant exceptions>) {
            button.setIcon(failedIcon);
        }
    }
}