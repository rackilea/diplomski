// Using while loop without inline assignment
//   Pro: Common construct
//   Con: Loop logic both before and at end of loop
//        Variable scope not limited to the loop
//        More code (lines of loop code: 4)
//        Calling the readLine() method in two places
String line = br.readLine();
while (line != null) {
    System.out.println(line);
    line = br.readLine();
}