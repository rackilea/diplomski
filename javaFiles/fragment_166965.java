enum Direction {
   NORTH(0), EAST(90), SOUTH(180), WEST(270);
   // so obvious! so easy to read! so easy to write! so easy to maintain!

   private final int degree;
   Direction(int degree)      { this.degree = degree; }
   public int getDegree()     { return degree; }
}

//...
for (Direction dir : Direction.values()) {
   ... dir.getDegree() ...
}