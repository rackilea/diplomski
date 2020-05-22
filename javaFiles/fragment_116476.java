// go through the first 30 lines without printing them...
for (int i = 0 ; i < 30 && scanner.hasNextLine() ; i++) {
    scanner.nextLine();
}

// and now print the remaining lines
while(scanner.hasNextLine())
    System.out.println(scanner.nextLine());