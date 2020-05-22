System.out.println("Enter an floating point number: ");
double d = i.nextDouble();
i.skip("((?<!\\R)\\s)*"); // skip whitespace, stopping after any newline

System.out.println("Enter a string: ");
String str = i.nextLine();