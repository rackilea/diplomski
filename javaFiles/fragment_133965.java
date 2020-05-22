String[] columns = new String[] { "_id", "item", "description" };

MatrixCursor matrixCursor = new MatrixCursor(columns );

 for (JsonElement mus : musics) {
           matrixCursor.addRow(new Object[] { 1, "Item A", "...." });
 }