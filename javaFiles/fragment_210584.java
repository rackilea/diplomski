JPanel panel = new JPanel();
final JLabel progressLabel = new JLabel("Some text before executing SwingWorker");
panel.add(progressLabel);

SwingWorker<Integer, String> worker = new SwingWorker<Integer, String>() {    
    @Override
    protected Integer doInBackground() throws Exception {
        if(cameraBoolean){
            pubish("Starting long process...");
            //Some processing here
            publish("Intermediate result to be published #1");
            //Some other processing stuff
            publish("Intermediate result to be published #2");
            //And so on...
            return 0;
        } else {
            publish("Could not contact camera "+camera.getName());
            return -1;
        }
    }

    @Override
    protected void process(List<String> chunks) {
        for(String string : chunks){
            progressLabel.setText(string);
        }
    }

    @Override
    protected void done() {
        progressLabel.setText("Finished!!!");
    }
};

worker.execute();