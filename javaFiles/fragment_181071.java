LongStream.iterate(1, i -> {
    System.out.println("LongStream incrementing " + i);
    return i + 1;
}).limit(1).count();

Stream.iterate(1L, i -> {
    System.out.println("Stream incrementing " + i);
    return i + 1;
}).limit(1).count();