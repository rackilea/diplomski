public void main(String... args) {
        List<String> dictionary = readDictionaryFrom("path to dictionary");
        List<String> monkeyText = generateTextFrom(dictionary);
        writeTextToFile(monkeyText, "path to destination file");
    }

    public List<String> readDictionaryFrom(String path) {
        try {
            return Files.readAllLines(new File(path).toPath());
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeTextToFile(List<String> text, String path) {
        try(BufferedWriter file = new BufferedWriter(new FileWriter(new File(path)))){
            for(String word : text) {
                file.write(word);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> generateTextFrom(List<String> words) {
        Random generator = new Random();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 10_000; i++) {
            int random = generator.nextInt(words.size());
            result.add(words.get(random));
        }
        return result;
    }