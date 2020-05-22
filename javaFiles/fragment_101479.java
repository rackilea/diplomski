barChart.setLegendVisible(false);
    VBox vbox = new VBox(barChart);

    Scene scene = new Scene(vbox);

    primaryStage.setScene(scene);
    primaryStage.show();

}

public static void main(String[] args) {
Application.launch(args);
}