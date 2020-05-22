public String getLineBreaker() {
  String box ="";
  Scanner scan = new Scanner(line);
  //scan.useRadix(breaker);
  //while (scan.hasNext()){
      for(int i = 0; i < breaker; i++){
      box += scan.next();

  }box += "\n";
  //}
}