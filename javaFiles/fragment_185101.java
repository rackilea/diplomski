public List<Integer> findTokens(Character operators[]) {
    Set<Character> set = new HashSet<>();
    set.addAll(Arrays.asList(operators));
    return tokenList.stream()
        .filter(x -> {
            return x.position >= startPosition &&
                    x.position <= endPosition &&
                    set.contains(x.operator);
        })
        .map(t -> t.position)
        .collect(Collectors.toList());
}