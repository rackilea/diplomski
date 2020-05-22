private ChangeListener<Boolean> focusListener = new ChangeListener<Boolean>() {
    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (!newValue) {
            sum(); //Do the sum logic here!!!
        }
    }
};