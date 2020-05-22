// pass the numberOfRows which is comboxBox.getValue()
// pass tableA and tableB.
private void calcul(GridePane tableA, GridPane tableB, int numberOfRows) {
    // first get the total and store it in a variable
    double total =0;
    for(Node node : tableA){
      if(node instanceof TextField){
         total += Double.parseDouble(((TextField)node).getText());
      }
    }

    // fetch the numbers (in a String format) from all TextFields at every row in tableA
    // and calculate the average after parsing the Strings from each as double values
    // set the average in the corresponding TextField in tableB in every loop
    double average = 0;
    for(int i=0 ; i<numberOfRows; i++){
       average = (Double.parseDouble(((TextField) getComponent (i, 0, tableA)).getText()) +
                  Double.parseDouble(((TextField) getComponent (i, 1, tableA)).getText()) +
                  Double.parseDouble(((TextField) getComponent (i, 2, tableA)).getText()))
                                           / (total);

       ((TextField) getComponent (i, 0, tableB)).setText(String.valueOf(average));

    }
}