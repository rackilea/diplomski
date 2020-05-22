public void updateData(){
    // You need to run it in thread
    Platform.runLater(() -> {
        // Update chart's name
        barChart.setTitle(questionName);
        // Remove all data
        series.getData().clear();
        // Add as many data as you want         
        series.getData().add(new XYChart.Data("xData", yValue));
    });
}