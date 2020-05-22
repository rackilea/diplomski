ColumnConstraints leftCol = new ColumnConstraints();
leftCol.setHalignment(HPos.RIGHT);
ColumnConstraints rightCol = new ColumnConstraints();
rightCol.setHgrow(Priority.ALWAYS);
rightCol.setfillWidth(true);

pane.getColumnConstraints().addAll(leftCol, rightCol);