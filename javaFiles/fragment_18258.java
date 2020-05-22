ColumnConstraints cc = new ColumnConstraints(100, 100, Double.MAX_VALUE, 
                                     Priority.ALWAYS, HPos.CENTER, true);
grid.getColumnConstraints().addAll(cc, cc);

RowConstraints rc = new RowConstraints(20, 20, Double.MAX_VALUE, 
                                     Priority.ALWAYS, VPos.CENTER, true);
grid.getRowConstraints().addAll(rc, rc);