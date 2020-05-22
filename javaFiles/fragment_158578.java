int[] numbers = new int[51];

// Small loop to get the number input
Scanner scanner = new Scanner(System.in);
for (int i=0; i<10; i++) {
    System.out.print("> ");
    int x = scanner.nextInt();

    if (x >= 0 && x <= 50) {
        numbers[x] += 1;
    }
}

// Now display the results after getting input
System.out.println("Number \t     Times");
for (int i=0; i<numbers.length; i++) {
    if (numbers[i] != 0) {
        System.out.println(i + "\t\t" + numbers[i]);
    }
}