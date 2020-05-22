// Using while loop with inline assignment
//   Pro: Common construct
//        Keeps the loop logic with the loop
//        Small amount of code (lines of loop code: 3)
//   Con: Variable scope not limited to the loop
//        Inline assignment
String line;
while ((line = br.readLine()) != null) {
    System.out.println(line);
}