String search = filenameText.getText();
File root = new File(dirName);
resultText.setText("");

Loading show = new Loading();
show.setVisible(true);

// create our worker
new SwingWorker<Void, Void> worker = new SwingWorker<>(){
    @Override
    protected Void doInBackground() throws Exception {
        displayDirectoryContents(root, search);
        return null;
    }
};

worker.addPropertyChangeListener(evt -> {
    if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
        // you should also call get() on the worker allowing
        // you to capture and handle all exceptions it might throw
        show.setVisible(false);
    }
});

worker.execute();  // run the worker