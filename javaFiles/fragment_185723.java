private static List<String> maxWords(int maxLength, String[] letters)
{
    if (letters.length == 0)
    {
        return Arrays.asList("");
    }

    Stream<String> s = Stream.of("");
    int[] capacity = { 1 };

    for (int i = 0; i < maxLength; i++)
    {
        s = Stream.concat(Stream.of(""), s.flatMap(word -> Arrays.stream(letters).map(word::concat)));
        capacity[0] = capacity[0] + (int) Math.pow(letters.length, i + 1);
    }

    return s.collect(Collectors.toCollection(() -> new ArrayList<>(capacity[0])));
}