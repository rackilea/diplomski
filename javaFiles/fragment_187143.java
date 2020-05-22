task.stateProperty().addListener(new ChangeListener<Worker.State>() {

        @Override
        public void changed(ObservableValue<? extends State> observable,
                State oldValue, Worker.State newState) {
            if(newState==Worker.State.SUCCEEDED){
                //doSomething()
            }
        }
    });