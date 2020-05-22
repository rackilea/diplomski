String text = "Question : how to search for a particular word in a " +
        "text file containing texts of words and return its " +
        "frequency or occurrences ?";

String word = "a";

int totalCount = 0;
int wordCount = 0;
Scanner s = new Scanner(text);
while (s.hasNext()) {
    totalCount++;
    if (s.next().equals(word)) wordCount++;
}

System.out.println("Word count:  " + wordCount);
System.out.println("Total count: " + totalCount);
System.out.printf("Frequency:   %.2f", (double) wordCount / totalCount);