AtomicInteger countEven = new AtomicInteger(0);
AtomicInteger countOdd = new AtomicInteger(0);

info.stream()                             // Stream<Shark> sharks
    .map(Shark::getLatinName)             // Stream<String> names
    .mapToInt(String::length)             // IntStream length of names
    .forEach(length -> {
        if (length % 2 == 0) {
            countEven.getAndIncrement();
        } else {
            countOdd.getAndIncrement();
        }
    });

System.out.println("Even words: " + countEven);
System.out.println("Odd words: " + countOdd);