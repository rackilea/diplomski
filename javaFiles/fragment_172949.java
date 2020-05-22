// Using break to exit forever loop
//   Pro: Limits the scope of the variable
//   Con: Loop logic both before and at end of loop
//        Using infinite loop and the break statement
//        More code (lines of loop code: 6)
for (;;) { // or: while (true)
    String line = br.readLine();
    if (line == null) {
        break;
    }
    System.out.println(line);
}