// Using for loop (recommended)
//   Pro: Keeps the loop logic with the loop
//        Limits the scope of the variable
//        Smallest amount of code (lines of loop code: 2)
//   Con: Unusual construct
//        Inline assignment
for (String line; (line = br.readLine()) != null; ) {
    System.out.println(line);
}