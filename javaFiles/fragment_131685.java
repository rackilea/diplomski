ArrayList<ArrayList<String>> ary = new ArrayList();
    int row = 0;
    while (rs.next()){ // Get next row
    ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= numFields; i++) { // each column
            columns.add(rs.getString(i));
        }
        ary.add(columns)
  }