pathTransition.statusProperty().addListener(new ChangeListener<Status>() {

    @Override
    public void changed(ObservableValue<? extends Status> observableValue,
                        Status oldValue, Status newValue) {
          if(newValue==Status.STOPPED){
                //do something
          }            
    }
});