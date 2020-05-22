public String ShowBoard() {
  // your code to populate StrArrayBoard

  StringBuilder boardBuilder = new StringBuilder();
  for (String[] row:StrArrayBoard)
    for (String cell:row)
      sb.append(cell);
  return boardBuilder.toString();
}

public String toString() {
  return ShowBoard();
}