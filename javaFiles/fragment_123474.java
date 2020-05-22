button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Create a Task
                Task<Boolean> task = new Task<Boolean>() {
                    @Override
                    protected Boolean call() throws Exception {
                        try {
                            //Invisible for 1000ms
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e) {
                            return Boolean.FALSE;
                        }
                        return Boolean.TRUE;
                    }
                };
                //Start the Task
                new Thread(task).start();
                //Bind the visibility with Task Value
                pane.visibleProperty().bind(task.valueProperty());
         }
});