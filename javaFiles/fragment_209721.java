class Cell {
  final int POSSIBILITES = 9;
  int actual_value;
  boolean[] possible_values = new boolean[POSSIBILITES]; // for each number
  Cell( int actual_value ) {
    this.actual_value = actual_value;
    for( int i = 0; i < POSSIBILITES; i++ )
      possible_values[i] = true;
  }
}