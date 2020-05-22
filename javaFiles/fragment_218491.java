// Create fake data
ArrayList<Integer> allRows = new ArrayList<Integer>();
for (int i = 0; i < 70; i++)
  allRows.add(i);

System.out.printf("All Data: %s%n", allRows.toString());

// Create 2 Dementional Array
ArrayList<ArrayList<Integer>> twoDRows = new ArrayList<ArrayList<Integer>>();
// Add the 5 rows
for (int i = 0; i < 5; i++)
    twoDRows.add(new ArrayList<Integer>());

// Split allRows
for (int i = 0; i<allRows.size(); i++) {
  int rowToAddTo;

  // Horizontal
  rowToAddTo = i/(allRows.size()/twoDRows.size());

  // Vertical
  rowToAddTo = i%twoDRows.size();

  twoDRows.get(rowToAddTo).add(allRows.get(i));
}

// Pretty-ish print
for (ArrayList<Integer> array:twoDRows)
  System.out.println(array);