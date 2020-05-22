public BasicView(String name) {
    super(name);

    Label label = new Label("This is a custom view");

    VBox controls = new VBox(15.0, label);
    controls.setAlignment(Pos.CENTER);

    setCenter(controls);

    setOnShowing(e -> System.out.println("Showing Event"));

    setOnHiding(e -> System.out.println("Hiding Event"));
}