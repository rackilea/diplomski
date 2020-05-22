public Cell getCell(Map<Integer, Map<Integer, Cell>> grid, int x, int y) {
     try {
         Cell found = grid.get(x).get(y);
         return found;
     } catch (NullPointerException npe) {
         return null;
     }
 }