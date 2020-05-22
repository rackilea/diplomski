while (rs.next()) {
    for (int i = 1; i <= meta.getColumnCount(); i++) {
         System.out.println("Column type: " + meta.getColumnType(i) + " Iteration: " + i); //log which data type the column has
         if(meta.getColumnType(i) == 93) {
              s2.setDate(i, rs.getDate(i));
        }else {
              s2.setObject(i, rs.getObject(i));
                                }                                   
                            }