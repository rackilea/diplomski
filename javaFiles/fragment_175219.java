public Collection<Point> validLocationsFrom(Point loc) {
   Collection<Point> validMoves = new HashSet<Point>();
   // Check for all valid movements
   for (int row = -1; row <= 1; row++) {
      for (int column = -1; column <= 1; column++) {
         try {
            //
            //TODO: Implement isFree(Point) to check in your map image
            //if a node is occupied or not.
            //
            if (isFree(new Point(loc.x + column, loc.y + row))) {
               validMoves.add(new Point(loc.x + column, loc.y + row));
            }
         } catch (ArrayIndexOutOfBoundsException ex) {
         // Invalid move!
         }
      }
   }
   validMoves.remove(loc);
   return validMoves;
}