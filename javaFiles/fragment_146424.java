package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

  @Override
  public void start(Stage primaryStage) {
    StackPane root = new StackPane(new Label("Hello, World!"));
    primaryStage.setScene(new Scene(root, 500, 300));
    primaryStage.show();
  }
}