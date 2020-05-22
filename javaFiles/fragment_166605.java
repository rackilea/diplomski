while (scanner.hasNext()) { // Loop over all tokens in the Scanner.
    if (scanner.hasNextInt()) {
        scanner.nextInt(); // Ignore this value since it's an Integer
    } else if (scanner.hasNextDouble()){
        double value = scanner.nextDouble();
        System.out.println(value);
    }
}