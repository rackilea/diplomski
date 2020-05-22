//inside your long running thread when you want to update a Swing component
SwingUtilities.invokeLater(new Runnable() {
    public void run() {

        //This will be called on the EDT
        progressBar.setValue(progressBar.getValue() + 1);


    }
});