WatchDir watchDir = new WatchDir(rootPath, false) ;
watchDir.setOnCreate(path -> 
    Platform.runLater(() -> listView.getItems().add(path)));
Thread watchThread = new Thread(watchDir::processEvents);
watchThread.setDaemon(true);
watchThread.start();