imageProperty().addListener(new ChangeListener<Image>() {
    @Override
    public void changed(ObservableValue<? extends Image> observable, Image oldValue, Image newValue) {
        System.out.println("imageProperty oldValue " + oldValue);
        System.out.println("imageProperty newValue " + newValue);
        System.out.println("");
    }
});