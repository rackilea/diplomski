sp.setOnMouseClicked(event -> {

    Task<Void> task = new Task<Void>()
    {
        @Override
        public Void call() throws Exception
        {
            for (Map.Entry<String, Integer> pair : dictionary.entrySet())
            {
                Platform.runLater(() -> {
                    labelUp.setText(pair.getKey());
                    labelDw.setText(pair.getValue().toString());
                });
                System.out.println(pair.getKey());
                Thread.sleep(250);
            }
            return null;
        }
    };
    new Thread(task).start();

});