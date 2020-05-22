public class Main {
    public static void main(String... args) {
        ArrayList<Sentence2> sentences = new ArrayList<>();
        String wordsJoin = "";
        int numOfWords = 0;

        String strLine = "It will be splitted? Sentence by sentence? Sure!";

        String[] tokens = strLine.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            if(strLine.isEmpty()){
                continue;
            }

            String s = tokens[i];
            wordsJoin += tokens[i] + " ";
            numOfWords += tokens.length;

            if (s.charAt(s.length() - 1) == '.' || s.charAt(s.length() - 1) == '?' || s.charAt(s.length() - 1) == '!') {
                sentences.add(new Sentence2(wordsJoin, numOfWords));
                wordsJoin = "";
                numOfWords = 0;
            }
        }

        for (Sentence2 sentence2 : sentences) {
            System.out.println(sentence2.wordsJoin + " " + sentence2.numOfWords);
        }
    }

    public static class Sentence2 {
        private String wordsJoin;
        private int numOfWords;

        public Sentence2(String wordsJoin, int numOfWords) {
            this.wordsJoin = wordsJoin;
            this.numOfWords = numOfWords;
        }
    }
}