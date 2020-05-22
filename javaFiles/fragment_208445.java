public static int[] imaliDuplikata(int[] combination) {
    Random r = new Random();
    Set<Integer> foundeNumbers = new HashSet<>();

    for (int i = 0; i < combination.length; i++) {
        if (foundeNumbers.contains(combination[i])) {
            combination[i] = r.nextInt(40);
        } else {
            foundeNumbers.add(combination[i]);
        }

    }
    return combination;
}