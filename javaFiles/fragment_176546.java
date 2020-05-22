final Stage stage ;
// ...

ChangeListener<Number> stageMoveListener = new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number new Value) {
        System.out.println("Stage moved to "+stage.getX()+", "+stage.getY());
    }
});
stage.xProperty().addListener(stageMoveListener);
stage.yProperty().addListener(stageMoveListener);