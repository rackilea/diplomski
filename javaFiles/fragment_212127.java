for (int key = 1; key <= 26; key++) {
    final int k = key;
    Arrays.asList(cipherletters).stream().map(n -> {
        int newPosition = Arrays.asList(alphabet).indexOf(n) + k;
        System.out.println("The new position of the letter " + n + " is " + newPosition);

        return newPosition;
    }).collect(Collectors.toSet());
}