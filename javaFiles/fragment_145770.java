String line = Read_one_Line(br);
while ( line != null ) {
  System.out.println(line);
  String dummy = Read_one_Line(br);
  line = Read_one_Line(br);
}