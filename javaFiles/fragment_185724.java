private static List<String> maxWords2(int maxLength, String[] letters)
{
    if (letters.length == 0)
    {
        return Arrays.asList("");
    }

    int capacity = IntStream.rangeClosed(0, maxLength)
                            .map(length -> (int) Math.pow(letters.length, length))
                            .sum();

    return IntStream.range(0, capacity).mapToObj(i -> {
        StringBuilder s = new StringBuilder();
        while (i > 0)
        {
            i--;
            s.append(letters[i % letters.length]);
            i /= letters.length;
        }
        return s.reverse().toString();
    }).collect(Collectors.toCollection(() -> new ArrayList<>(capacity)));
}