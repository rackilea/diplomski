package fxmltest;

import javafx.fxml.FXML;

public class SomeController {

  @FXML
  public void print(String s){
    System.out.println("from javascript: "+s);
  }
}