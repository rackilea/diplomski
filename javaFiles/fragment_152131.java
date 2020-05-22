List<List<GameObject>> board = new ArrayList<>();

List<GameObject> firstRow = new ArrayList<>();
firstRow.add(new GameObject()); // first cell of first row
firstRow.add(new GameObject()); // second cell of first row
...
board.add(firstRow);

List<GameObject> secondRow = new ArrayList<>();
secondRow.add(new GameObject()); // first cell of second row
secondRow.add(new GameObject()); // second cell of second row
...
board.add(secondRow);
...