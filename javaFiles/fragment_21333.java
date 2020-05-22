public String toString() {
  StringBuilder output = new StringBuilder("[");
  if ( stackTop > 0 ) {
     for (int i = stackTop - 1; i >= 0; i--) {
        if ( i == 0 ) {
           output.append(list[i].toString());
        }
        else {
           output.append(list[i].toString() + "|");
        }
     }
  }
  output.append("]");
  return output.toString();
}