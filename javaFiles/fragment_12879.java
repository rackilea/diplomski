Label lbl = new Label("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
lbl.setPrefWidth(50);
lbl.setWrapText(true);

MenuItem menuItem = new MenuItem();
menuItem.setGraphic(lbl);

contextMenu.getItems().add(menuItem);