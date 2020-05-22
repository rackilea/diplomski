try (final Scanner data = new Scanner(file)) {
    final int lines = data.nextInt();
    final Collection<Double> totalPerLine = new ArrayList<>(lines);

    for (int i = 0; i < lines; i++) {
        double sum = 0;

        for (int j = 0; j < 13; j++) {
            final int value = data.nextInt();
            sum += getDollars(j, value);
        }

        totalPerLine.add(sum);
        System.out.println("Line " + i + ": $" + sum);
    }
}