for(String line : lines){
  int colonIndex = line.indexOf(':');
  int num = Integer.parseInt(line.substring(0,colonIndex);
  List<String> nums = parseNums(line.substring(colonIndex+1));
  //do something
}

private List<Integer> parseNums(String s){
  //you say you already know how to do this.
}