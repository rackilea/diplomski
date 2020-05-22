// pass the numberOfRows which is comboxBox.getValue()
// pass tableA and tableB.
// fetch the numbers (in a String format) from all TextFields at every row in tableA
// and caclulate the result after parsing the Strings from each as double values
// set the result in the corresponding TextField in tableB in every loop
private void calcul(GridePane tableA, GridPane tableB, int numberOfRows) {
     double result = 0;
     for(int i=0 ; i<numberOfRows; i++){
        result = (Double.parseDouble(((TextField) getComponent (i, 0, tableA)).getText()) +
                  Double.parseDouble(((TextField) getComponent (i, 1, tableA)).getText()) +
                  Double.parseDouble(((TextField) getComponent (i, 2, tableA)).getText()))
                                            / (numberOfRows*3);

        ((TextField) getComponent (i, 0, tableB)).setText(String.valueOf(result));

     }
}