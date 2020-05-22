Platform.runLater(() -> {

    lineChart.getData().remove(toFront);
    lineChart.getData().add(toFront);

});