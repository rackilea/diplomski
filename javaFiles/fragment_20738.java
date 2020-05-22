String input = "2.1 20 Something true";
Scanner s = new Scanner(input);
float f = s.nextFloat();
int i = s.nextInt();
String str = s.next(); // next() doesn't parse, you automatically get a string
boolean b = s.nextBoolean();