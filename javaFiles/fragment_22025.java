// imports here

public class QuestionCollection {
    private List<Question> easyQuestions = new ArrayList<>();
    private List<Question> mediumQuestions = new ArrayList<>();
    private List<Question> hardQuestions = new ArrayList<>();

    public void addQuestion(Question q) {
        switch (q.getDifficulty()) {
        case EASY:
            easyQuestions.add(q);
            break;
        case MEDIUM:
            mediumQuestions.add(q);
            break;
        case HARD:
            hardQuestions.add(q);
        }
    }

    public Question getRandomQuestion(int percentEasy, int percentMedium, int percentHard) {
        // if the numbers don't add up to 100, the distribution is broken -- throw an exception
        if (percentEasy + percentMedium + percentHard != 100) {
            String format = "For percentEasy: %d, percentMedium: %d, percentHard: %d";
            String text = String.format(format, percentEasy, percentMedium, percentHard);
            throw new IllegalArgumentException(text);
        }

        List<Question> randomList = null;
        int rand = (int) (100 * Math.random());
        if (rand < percentEasy) {
            randomList = easyQuestions;
        } else if (rand < percentEasy + percentMedium) {
            randomList = mediumQuestions;
        } else {
            randomList = hardQuestions;
        }

        // we've now selected the correct List
        // now get a random question from the list:

        // first get a random index to the list from 0 to < size
        int size = randomList.size();
        int listIndex = (int)(size * Math.random());
        Question randomQuestion = randomList.get(listIndex);
        return randomQuestion;
    }
}