mainStage.widthProperty().addListener((o, oldValue, newValue)->{
    if(newValue.intValue() < 400.0) {
        mainStage.setResizable(false);
        mainStage.setWidth(400);
        mainStage.setResizable(true);
    }
});