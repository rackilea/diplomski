String rx = "[^\"\\s]+|\"(\\\\.|[^\\\\\"])*\"";
Scanner scanner = new Scanner("P 160 SomethingElse \"A string literal\" end");
System.out.println(scanner.findInLine(rx)); // => P
System.out.println(scanner.findInLine(rx)); // => 160
System.out.println(scanner.findInLine(rx)); // => SomethingElse
System.out.println(scanner.findInLine(rx)); // => "A string literal"
System.out.println(scanner.findInLine(rx)); // => end