Scanner sc = new Scanner(new File("myFile"));
while (sc.hasNextLine()) {
   String aLine = sc.nextLine();
   String field1 = aLine.subString(0,6);
   String field2 = aLine.subString(6,11);
   ...
}