String[] words = { "hello", "heavy", "word" };

int biggestSum = 0;
String biggestWord = null;

for (String word : words) {
    int sum = 0;

    for (char ch : word.toLowerCase().toCharArray()) {
        if (ch >= 'a' && ch <= 'z') {
            sum += 1 + ch - 'a';
        }
    }

    if (sum > biggestSum) {
        biggestSum = sum;
        biggestWord = word;
    }

    System.out.printf("%s %d%n", word, sum);
}

System.out.printf("Biggest word: %s %d%n", biggestWord, biggestSum);