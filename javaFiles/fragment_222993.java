public BasicView(String name) {
    super(name);

    // create a custom layer
    MobileApplication.getInstance().addLayerFactory("My Layer", () -> new Layer() {
        private final Node root;
        private final double size = 300;

        {
            root = new StackPane(new Button("A custom layer"));
            root.setStyle("-fx-background-color: lightgreen;");
            getChildren().add(root);
            getApp().getGlassPane().getLayers().add(this);

            // Add event handler to listen to Android Back Button Pressed event, hiding the layer
            addEventHandler(MobileApplication.MobileEvent.BACK_BUTTON_PRESSED, e -> {
                    hide();
                    e.consume();
            });
        }

        @Override
        public void hide() {
            setShowing(false);
            super.hide(); 
        }

        @Override
        public void layoutChildren() {
            root.setVisible(isShowing());
            if (!isShowing()) {
                return;
            }
            root.resize(size, size);
            resizeRelocate(0, 0, size, size);
        }
    });

    Button button = new Button("Show Layer");
    button.setOnAction(e -> MobileApplication.getInstance().showLayer("My Layer"));

    VBox controls = new VBox(15.0, button);
    controls.setAlignment(Pos.CENTER);

    setCenter(controls);
}