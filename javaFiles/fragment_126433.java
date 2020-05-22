initLoadingPanel();
SwingWorker worker = new SwingWorker<CVS, CVS>() {

    @Override
    protected CVS doInBackground() throws Exception {
        return FileReaderCSVHelper.fileReader(dirName.getText(), fileName.getText());
    }

    @Override
    protected void done() {
        try {
            cvs = get();
            generateTableList(csv.getCsvTitle(), stateController.getFieldNames());
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
        loader.dispose();
    }

};
worker.execute();