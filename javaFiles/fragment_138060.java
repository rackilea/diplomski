//in Core.java start() method
yourScene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

//in your fxml controller
M1chart.getStyleClass().add("m1chart");
M2chart.getStyleClass().add("m2chart");
L1chart.getStyleClass().add("l1chart");