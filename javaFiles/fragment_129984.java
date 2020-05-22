System.out.println(lines.stream()
    .map(line -> line.split(" "))
    .flatMap(Arrays::stream)
    .map(word -> word.trim().toLowerCase())
    .filter(word -> word.equals(theWord))
    .count());