for (int line = 1; line <= 6; line++){
  for(int i = 1; i<=line-1; i++) {
    System.out.print("\\");
  }
  for (int i = 1; i <= 22 - 4*(line-1); i++){
    System.out.print("!");
  }
  for(int i = 1; i<=line-1; i++) {
    System.out.print("//");
  }
  System.out.println();
}