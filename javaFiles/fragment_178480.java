// Add a checkbox, wrapped in an HBox, to the second row
final CheckBox checkbox2 = new CheckBox("CB Text 2");
final HBox hbox = new HBox(checkbox2);
hbox.setFillHeight(true);          // Added this
hbox.setAlignment(Pos.CENTER_LEFT);// Changed the alignment to center-left
root.add(hbox, 1, 1);
//GridPane.setValignment(hbox, VPos.BASELINE); This is unnecessary