public int compareTo(Object other) {
  if( this.getDistanceFromPlayer() < other.getDistanceFromPlayer() ) {
      return -1;
  } else if( this.getDistanceFromPlayer() > other.getDistanceFromPlayer())  {
      return 1;
  }
  return 0;
}