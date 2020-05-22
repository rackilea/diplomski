customStage.show();

new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            doOperation();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // close stage on javafx application thread
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                customStage.close();
            }

        });
    }
}).start();