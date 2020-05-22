private static final Random RANDOM = new Random();

public static void main(String[] args) {
    System.out.println(randomPerm("aaabcc"));
}

public static String randomPerm(String str) {
    Map<Character, Long> counts = str
            .chars()
            .mapToObj(c -> (char) c)
            .collect(groupingBy(Function.identity(), Collectors.counting()));
    return restPerm(null, counts);
}

public static String restPerm(Character previous, Map<Character, Long> leftover) {
    List<Character> leftKeys = new ArrayList<>(leftover.keySet());
    while (!leftKeys.isEmpty()) {
        Character nextChar = leftKeys.get(RANDOM.nextInt(leftKeys.size()));
        leftKeys.remove(nextChar);
        if (nextChar.equals(previous) || leftover.get(nextChar) == 0) {
            continue; // invalid next char
        }
        // modify map in place, reduce count by one
        Long count = leftover.compute(nextChar, (ch, co) -> co - 1);
        if (leftover.values().stream().noneMatch(c -> c > 0)) {
            return nextChar.toString();  // last char to use
        }
        String rest = restPerm(nextChar, leftover); // recurse
        if (rest != null) {
            return nextChar + rest; // solution found
        }
        leftover.put(nextChar, count + 1);
    }
    return null;
}