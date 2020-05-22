String s = "blahhh foo.... I'm a very long string, with long lines and
a lot of linebreaks...";

String[] looping = s.split("\n"); // whatever delimiter you need

for(int i = 0 ; i < looping.length ; i++) {
  // print 
  System.out.print(looping[i]);

  // wait for user input
  Scanner scanner = new Scanner(System.in);
  String a =  scanner.nextLine(); 

  // assigne a key to stop the loop before the end
  if(a.equalsIgnoreCase("X") // X, or whatever you want
  break;
}