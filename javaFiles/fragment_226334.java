private static BackgroundTask backgroundTask;
private static Thread thread;

tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

        @Override
        public void changed(final ObservableValue observable, final Object oldValue, final Object newValue) {

            //I close previous running background tasks if there's any 
            if (backgroundTask != null) {
                while (backgroundTask.isRunning()) {
                    backgroundTask.cancel(true);
                    // reset GUI nodes here used to show results of the previous thread
                }

            }

            backgroundTask = new BackGoundTask();
            thread= new Thread(backgroundTask);
            thread.setDaemon(true);
            thread.start();

            //This will be called only when latest recursion is finished, not at every run
            backgroundTask.setOnSucceeded(e -> {});

        }

    });