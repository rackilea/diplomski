Platform.runLater(new Runnable() {

    @Override
    public void run() {
        final StackPane region = (StackPane) tabPane.lookup(".headers-region");
        final StackPane regionTop = (StackPane) tabPane.lookup(".tab-pane:top *.tab-header-area");
        regionTop.widthProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                Insets in = regionTop.getPadding();
                regionTop.setPadding(new Insets(
                        in.getTop(),
                        in.getRight(),
                        in.getBottom(),
                        arg2.doubleValue() / 2 - region.getWidth() / 2));
            }
        });
        // force re-layout so the tabs aligned to center at initial state
        stage.setWidth(stage.getWidth() + 1);
    }
});