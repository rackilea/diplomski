WatchDir watchDir = new WatchDir(rootPath, false) ;
watchDir.setNotificationExecutor(Platform::runLater);
watchDir.setOnCreate(listView.getItems()::add); /* or path -> listView.getItems().add(path) */
Thread watchThread = new Thread(watchDir::processEvents);
watchThread.setDaemon(true);
watchThread.start();