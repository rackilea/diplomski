class RandomWordProvider {

    private List<String> words;

    public RandomWordProvider() {
        words = readFile();
    }

    private int randomInteger() {
        int randomInt = (int) (Math.random() * words.size());
        return randomInt;
    }

    public String getWord(int randomInt, String line) {
        int randomPosition = randomInteger();
        String randomWord = words.get(randomPosition);
        return randomWord;
    }

    private List<String> readFile() {

        List<String> wordsList = new ArrayList<>();

        try {
            String fileName = "C:/FourLetterWords.txt";
            File fourLetterWords = new File(fileName);
            Scanner in = new Scanner(fourLetterWords);

            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line!=null && !line.isEmpty()) {
                    wordsList.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        return wordsList ;
    }
}