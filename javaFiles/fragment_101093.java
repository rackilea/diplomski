public void split(Stream<String> lines)
{
    Pattern pairFinder = Pattern.compile("<pair-starter|pair-ender>");
    Pattern spaceFinder = Pattern.compile("[\\s]+");

    Map<String, String> pairs = new HashMap<>();

    List<String> words = lines.flatMap(pairFinder::splitAsStream).flatMap(pairOrNoPair -> {
        if (pairOrNoPair.startsWith(">") && pairOrNoPair.endsWith("<"))
        {
            pairOrNoPair = pairOrNoPair.replaceAll("> +| +<", "");

            String[] pair = spaceFinder.split(pairOrNoPair);
            pairs.put(pair[0], pair[1]);
            return Arrays.stream(pair);
        }
        else
        {
            return spaceFinder.splitAsStream(pairOrNoPair.trim());
        }
    })
                              .filter(this::filterPunctuation) // This removes the dot in example
                              .map(this::removePunctuation) // This removes the comma
                              .collect(Collectors.toList());

    System.out.println(words);
    System.out.println(pairs);
}

// Output
// [A, random, text, file, I, am, first, second, and, it, goes, on, and, on, and, hopefully, it, ends]
// {first=second}

boolean filterPunctuation(String s)
{
    return !s.matches("[,.?!]");
}

String removePunctuation(String s)
{
    return s.replaceAll("[,.?!]", "");
}