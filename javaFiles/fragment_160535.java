mainPane.boundsInLocalProperty().addListener((obs, oldBounds, newBounds) -> {
        mainPane.getChildren().clear();
        double horRadius = (mainPane.getWidth() / 2) - 10;
        double vertRadius = (mainPane.getHeight() / 2) - 10;
        addCircles(horRadius, vertRadius);
    });
    Scene scene = new Scene(mainPane, 500, 500);