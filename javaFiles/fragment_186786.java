package triviagame;

import Question;

public class TriviaGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the New Age Trivia game");
        System.out.println("You will be asked five questions, let us begin");
        Question questionArray[] = new Question[5];
        for (int i = 0; i < questionArray.length; i++) {
            questionArray[i] = new Question();
        }
    }
}