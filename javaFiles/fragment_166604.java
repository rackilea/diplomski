if (scanner.hasNext()) {
    if (scanner.hasNextInt()) {
        scanner.nextInt(); // Ignore this value since it's an Integer
    } else if (scanner.hasNextDouble()){
        double value = scanner.nextDouble();
        System.out.println(value);
    }
}