// can extract annotation and text-inside-parentheses
    private static final String REGEX = "@(\\w+)\\((.+)\\)";


    //Read File
    List<String> lines = Files.readAllLines(Paths.get(filename));

    //Create a pattern to find for
    Pattern pattern = Pattern.compile(REGEX);

    // extractor function uses pattern's second group (text-within-parentheses)
    Function<String, String> extractOnlyTextWithinParentheses = s -> {
        Matcher m = pattern.matcher(s);
        m.find();
        return m.group(2);
    };

    // all lines are filtered and text will be extracted using extractor-fn
    Stream<String> streamOfExtracted = lines.stream()
            .filter(pattern.asPredicate())
            .map(extractOnlyTextWithinParentheses);

    //Perform desired operation
    streamOfExtracted.forEach(System.out::println);