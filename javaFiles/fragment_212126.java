Function<String, Integer> yourF = n -> {
    int newPosition = Arrays.asList(alphabet).indexOf(n) + key;
    System.out.println("The new position of the letter " + n + " is " + newPosition);

    return newPosition;
};