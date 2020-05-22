Label label= new Label("i");
label.getStyleClass().add("my-Class");
Tooltip tooltip = new Tooltip(“xxx”);
label.setTooltip(tooltip);

List<CssMetaData< ? extends Styleable, ? >> cssProperties = ex2.getCssMetaData().stream().filter(t -> t.getProperty().equals("-fx-font")).findFirst().get().getSubProperties();
boolean inherits = cssProperties.stream().filter(t -> t.getProperty().equals("-fx-font-style")).findFirst().get().isInherits(); // Returns true