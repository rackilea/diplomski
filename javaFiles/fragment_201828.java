Scanner input = new Scanner(System.in);

if (!input.hasNextInt()) {
    System.exit(1);
}

// "else"
doMagicalThings(input.nextInt());