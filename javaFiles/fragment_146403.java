public String toString() {
    StringBuilder builder =new StringBuilder();
    builder.append("The permutation of this Individual is the following: ");
    builder.append("\n");//This to end a line
    for (int i=0; i<size; i++){
       builder.append(" " + i);
    }
    builder.append("\n");
    for (int i=0; i<size; i++) {
       builder.append(" " + individual[i]);
    }
    builder.append("\n");
    builder.append("Where the top row indicates column of queen, and bottom indicates row of queen");
    builder.append("\n");
    return builder.toString();
  }