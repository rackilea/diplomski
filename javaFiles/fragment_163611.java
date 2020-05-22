//Event Button Search
        btnFind.setOnAction(event -> {
            newFind();
            if (Config.isRoot()) {
                String finalSFilterExt = filterExt.getText();
                String finalSearchW = searchWord.getText();
                if (findThread != null && findThread.isAlive())
                    findThread.interrupt();
                findThread = new Thread(() -> {
                    try {
                        Thread.sleep(2000);
                        System.out.println("++++++++++++++");
                        var q =treeView.filterChanged(finalSFilterExt, finalSearchW);
                        Platform.runLater(()->{fileView.setRoot(q);});
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    });
                findThread.setName("findThread");
                findThread.setDaemon(true);
                findThread.start();
            }
        });