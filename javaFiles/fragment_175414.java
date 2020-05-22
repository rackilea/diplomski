for(int i=0; i<input+2; i++) {
  for(int j=0; j<input+2; j++) {
    if(i == 0 || i == input+1) {
      System.out.print("X ");
    } else {
      if(j == 0 || j == input+1) {
        System.out.print("X ");
      } else {
        System.out.print("* ");
      }
    }
  }
  System.out.println();
}