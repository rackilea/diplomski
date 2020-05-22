GridPane gp = new GridPane();
TextField[] tf = new TextField[userEnteredNumber];
for (int i = 0; i < userEnteredNumber; i++) {
    tf[i] = new TextField();
}
gp.addRow(row_index, tf);