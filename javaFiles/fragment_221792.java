import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;

public class Main {

    private static Scanner console = new Scanner(System.in);

    private static List<String> POSSIBLE_ANSWERS = List.of("A", "B", "C", "D");

    private static List<Answer> createAnswers(List<String> values) {
        return IntStream.iterate(0, i -> i < values.size() && i < POSSIBLE_ANSWERS.size(), i -> i + 1)
                .mapToObj(i -> new Answer(POSSIBLE_ANSWERS.get(i), values.get(i)))
                .collect(toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        var questions = List.of(
                new Question("1+1", createAnswers(List.of("2", "3", "4", "5")), "A"),
                new Question("2+2", createAnswers(List.of("2", "3", "4", "5")), "C"));

        var results = new ArrayList<Boolean>();
        for (var i = 0; i < questions.size(); i++) {
            var question = questions.get(i);
            System.out.printf("Question %d: %s%n", i + 1, question.getQuestion());
            for (var answer : question.getAnswers()) {
                System.out.printf("- %s. %s%n", answer.getLetter(), answer.getValue());
            }

            String user_input;
            do {
                System.out.printf("Chose one of %s:%n", POSSIBLE_ANSWERS);
                user_input = String.valueOf(console.next().charAt(0));

            } while (!POSSIBLE_ANSWERS.contains(user_input));

            var result = question.getCorrectAnswer().equals(user_input);
            results.add(result);
            System.out.println(result + "\n");
        }

        System.out.println("Results: " + results);
    }
}