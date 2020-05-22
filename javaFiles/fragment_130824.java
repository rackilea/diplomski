// Tells the HBox to expand the tabPane whenever possible.
HBox.setHgrow(tabPane, Priority.ALWAYS);

// If invisible, menuButton will not take space on the screen
menuButton.managedProperty().bind(menuButton.visibleProperty());

// A click on the tabPane will make menuButton invisible, freeing room for the tabPane to take over the rest of the HBox
tabPane.setOnMouseClicked(event -> menuButton.setVisible(false));