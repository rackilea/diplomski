Path path = Paths.get("myFile.txt");

List<String> lines = Files.readAllLines(path);
List<String> words = new ArrayList<>();

// Read words
for (String line : lines) {
    String[] wordsOfLine = line.split(" ");
    words.addAll(Arrays.asList(wordsOfLine));
}

// Count even and odd words
int countEven = 0;
int countOdd = 0;
for (String word : words) {
    if (word.length() % 2 == 0) {
        countEven++;
    } else {
        countOdd++;
    }
}

System.out.println("Even words: " + countEven);
System.out.println("Odd words: " + countOdd);