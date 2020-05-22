btn.setOnAction(new EventHandler<ActionEvent>(){
    @Override
    public void handle(ActionEvent arg0) {
        // 1
        setBackgroundProcessing(true); 

        // 2
        new Thread() {
            public void run() {
                doProcessing();

                // 3
                Platform.runLater(new Runnable() {
                    public void run() {
                        displayResults();
                        setBackgroundProcessing(false);
                    }
                });
            }
        }.start();
    }
});