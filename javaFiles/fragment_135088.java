Path path = Paths.get("myFile.txt");
AtomicInteger countEven = new AtomicInteger(0);
AtomicInteger countOdd = new AtomicInteger(0);
Pattern wordPattern = Pattern.compile(" ");

Files.lines(path)                         // Stream<String> lines
    .flatMap(wordPattern::splitAsStream)  // Stream<String> words
    .mapToInt(String::length)             // IntStream length
    .forEach(length -> {
        if (length % 2 == 0) {
            countEven.getAndIncrement();
        } else {
            countOdd.getAndIncrement();
        }
    });


System.out.println("Even words: " + countEven.get());
System.out.println("Odd words: " + countOdd.get());