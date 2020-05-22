ToggleButton btn = new ToggleButton("Say 'Hello World'");
btn.setOnAction((ActionEvent event) -> {
    System.out.println("Hello World!");
});

...
scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());