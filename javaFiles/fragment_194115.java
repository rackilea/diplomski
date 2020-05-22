IntStream.range(0, 10000).parallel().forEach(i -> {
    try {
        new File(String.valueOf(i)).createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
});