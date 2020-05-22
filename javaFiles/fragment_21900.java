zoom.addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> ov, Number t, Number newZoom) {
        System.out.println("Zoom=" + newZoom.doubleValue());
        content.setScaleX(newZoom.doubleValue());
        content.setScaleY(newZoom.doubleValue());
    }
});