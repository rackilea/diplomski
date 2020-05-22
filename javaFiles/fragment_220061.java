String sentence = "Hello how in the Hello world are you ? are you okay? Hello";
String[] words = Pattern.compile("\\W+").split(sentence); // split the sentence into words

Map<String, Integer> list = Arrays.stream(words)
        .collect(Collectors.groupingBy(x -> x))
        .entrySet().stream()
        .filter(x -> x.getValue().size() != 1) // remove the words that are not repeated 
        .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().size()));