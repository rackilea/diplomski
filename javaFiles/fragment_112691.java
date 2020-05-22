Platform.runLater(() -> {
            Pane title = (Pane) titlePane.lookup(".title");
             title.setPrefHeight(value);
             //or
             title.prefHeightProperty().bind(gridPane.heightProperty());
            });