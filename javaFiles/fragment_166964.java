// BEFORE: with int constants
public static final int NORTH = 0;
public static final int EAST  = 1;
public static final int SOUTH = 2;
public static final int WEST  = 3;

public static int degreeFor(int direction) {
   return direction * 90; // quite an assumption!
   // must be kept in-sync with the int constants!
}

//...
for (int dir = NORTH; dir <= WEST; dir++) {
   ... degreeFor(dir) ...
}