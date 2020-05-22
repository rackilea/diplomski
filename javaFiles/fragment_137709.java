String input = "1 fish 2 fish red fish blue fish";

 // \\s* means 0 or more repetitions of any whitespace character 
 // fish is the pattern to find
 Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");

 System.out.println(s.nextInt());   // prints: 1
 System.out.println(s.nextInt());   // prints: 2
 System.out.println(s.next());      // prints: red
 System.out.println(s.next());      // prints: blue

 // don't forget to close the scanner!!
 s.close();