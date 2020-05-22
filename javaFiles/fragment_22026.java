// imports

public class QuestionFun {
    public static void main(String[] args) {
        // create QuestionCollection object
        QuestionCollection questionCollection = new QuestionCollection();

        // fill it with questions with random difficulty
        for (int i = 0; i < 1000; i++) {
            String question = "Question #" + i;
            String answer = "Answer #" + i;
            int randomIndex = (int) (Difficulty.values().length * Math.random());
            Difficulty difficulty = Difficulty.values()[randomIndex];
            Question q = new Question(question, answer, difficulty);
            questionCollection.addQuestion(q);
        }

        Map<Difficulty, Integer> frequencyDistMap = new EnumMap<>(Difficulty.class);
        for (Difficulty diff : Difficulty.values()) {
            frequencyDistMap.put(diff, 0);
        }

        int easyPercent = 20;
        int mediumPercent = 70;
        int hardPercent = 10;

        int questionCount = 10000;
        for (int i = 0; i < questionCount; i++) {
            Question q = questionCollection.getRandomQuestion(easyPercent, mediumPercent, hardPercent);
            Difficulty difficulty = q.getDifficulty();
            int currentCount = frequencyDistMap.get(difficulty);
            currentCount++;
            frequencyDistMap.put(difficulty, currentCount);
        }

        System.out.println("Difficulty: Count (Percent)");
        String format = "%-12s %4d   (%02d)%n";
        for (Difficulty difficulty : Difficulty.values()) {
            int number = frequencyDistMap.get(difficulty);
            int percent = (int) Math.round((100.0 * number) / questionCount);
            System.out.printf(format, difficulty + ":", number, percent);
        }
    }
}