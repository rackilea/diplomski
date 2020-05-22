Scanner readfile = new Scanner(new File("data.txt"));
while (readfile.hasNextLine()) {
    String[] words = readfile.nextLine().split("\\s");
    for (int i=0; i<words.length-1; i++) {
        phraseSet.add(words[i] + " " + words[i+1]);
    }
}