Pane pane = new Pane();
Text text = new Text("");
text.relocate(10, 10);

pane.getChildren().add(text);
Task<Void> task = new Task<Void>() {
    {
        updateMessage("Initial text");
    }

    @Override
    public Void call() throws Exception {
        int i = 0;

        while (true) {
            if (i > 4)
                updateMessage("I is bigger than 4");

            if (i > 10)
                updateMessage("I is bigger than 10");

            i++;
            Thread.sleep(1000);
        }
    }
};

text.textProperty().bind(task.messageProperty());

Thread th = new Thread(task);
th.setDaemon(true);
th.start();