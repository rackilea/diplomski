final List<String> permutations = new ArrayList<>(26 * 26);
for (char[] array = {'a', 'a'}; array[0] <= 'z'; array[0]++) {
    for (array[1] = 'a'; array[1] <= 'z'; array[1]++) {
        permutations.add(new String(array));
    }
}