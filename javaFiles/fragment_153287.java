import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomMathQuestionGenerator {

    private static final int NUMBER_OF_QUESTIONS = 10;
    private static final int MIN_QUESTION_ELEMENTS = 2;
    private static final int MAX_QUESTION_ELEMENTS = 4;
    private static final int MIN_QUESTION_ELEMENT_VALUE = 1;
    private static final int MAX_QUESTION_ELEMENT_VALUE = 100;
    private final Random randomGenerator = new Random();

    public static void main(String[] args) {
        RandomMathQuestionGenerator questionGenerator = new RandomMathQuestionGenerator();
        List<Question> randomQuestions = questionGenerator.getGeneratedRandomQuestions();
        for (Question question : randomQuestions) {
            System.out.println(question);
        }
    }

    public List<Question> getGeneratedRandomQuestions() {
        List<Question> randomQuestions = new ArrayList<Question>(NUMBER_OF_QUESTIONS);
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            int randomQuestionElementsCapacity = getRandomQuestionElementsCapacity();
            Question question = new Question(randomQuestionElementsCapacity);
            for (int j = 0; j < randomQuestionElementsCapacity; j++) {
                boolean isLastIteration = j + 1 == randomQuestionElementsCapacity;

                QuestionElement questionElement = new QuestionElement();
                questionElement.setValue(getRandomQuestionElementValue());
                questionElement.setOperator(isLastIteration ? null
                        : Operator.values()[randomGenerator.nextInt(Operator.values().length)]);

                question.addElement(questionElement);
            }
            randomQuestions.add(question);
        }
        return randomQuestions;
    }

    private int getRandomQuestionElementsCapacity() {
        return getRandomIntegerFromRange(MIN_QUESTION_ELEMENTS, MAX_QUESTION_ELEMENTS);
    }

    private int getRandomQuestionElementValue() {
        return getRandomIntegerFromRange(MIN_QUESTION_ELEMENT_VALUE, MAX_QUESTION_ELEMENT_VALUE);
    }

    private int getRandomIntegerFromRange(int min, int max) {
        return randomGenerator.nextInt(max - min + 1) + min;
    }
}

class Question {

    private List<QuestionElement> questionElements;

    public Question(int sizeOfQuestionElemets) {
        questionElements = new ArrayList<QuestionElement>(sizeOfQuestionElemets);
    }

    public void addElement(QuestionElement questionElement) {
        questionElements.add(questionElement);
    }

    public List<QuestionElement> getElements() {
        return questionElements;
    }

    public int size() {
        return questionElements.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (QuestionElement questionElement : questionElements) {
            sb.append(questionElement);
        }
        return sb.toString().trim();
    }
}

class QuestionElement {

    private int value;
    private Operator operator;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return value + (operator == null ? "" : " " + operator.getDisplayValue()) + " ";
    }
}

enum Operator {

    PLUS("+"), MINUS("-"), MULTIPLIER("*"), DIVIDER("/");
    private String displayValue;

    private Operator(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}