for(int i=1; i<3; i++){
  // % - start of format
  // 0 - 0-pad the result
  // 7 - set result width to 7 characters wide
  // d - display as decimal integer
  String id = String.format("ABC%07d", i);
  System.out.println(id);
}