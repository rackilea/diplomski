Map<String, AtomicInteger> map = new HashMap<>();

    Consumer<String> countWords = word -> map.computeIfAbsent(word, (w) -> new AtomicInteger(0)).incrementAndGet();

    try (BufferedReader fileReader = new BufferedReader(new FileReader("resources/hugeFile"))) {
        String line;
        while ((line = fileReader.readLine()) != null) {
            splitAndConsumeWords(line, countWords);
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }