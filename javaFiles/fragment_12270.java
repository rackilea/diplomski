public static char nMostCommon(String str, int n) {
    Map<Character, Long> counter = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    if (counter.size() < n) {
        throw new IllegalArgumentException("Not enough different characters.");
    }
    return counter.entrySet().stream()
        .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList())
        .get(n - 1);
}

public static void main(String[] args) {
    System.out.println(nMostCommon("bananassss", 2));
}