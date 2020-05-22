public static ArrayList<ArrayList<Integer>> generateTable(int index, 
      int[] current, int[] values, ArrayList<ArrayList<Integer>> out) {
    int Alternative = 0;
    if(index == values.length) {
      ArrayList<Integer> row = new ArrayList();
      for(int i = 0; i < values.length; i++) {
        if (current[i] != Alternative) {
          row.add(current[i]);
        }
      }
      if (row.size() > 0) {
        out.add(row);
      }
    } else {
      current[index] = Alternative;
      generateTable(index + 1, current, values, out);
      current[index] = values[index];
      generateTable(index + 1, current, values, out);
    }
    return out;
  }