public class StackOverFlowTagConsumer {

    public static void main(String[] args) {
        List<Question> currentQuestions = new ArrayList<>();

        // if some action to sort by votes
        displaySortedByVotes(currentQuestions);

        // if another action to sort by newest
        displaySortedByNewest(currentQuestions);
    }

    private static void displaySortedByVotes(List<Question> currentQuestions) {
        System.out.println(StackOverflowTag.sortByVotes(currentQuestions));
    }

    private static void displaySortedByNewest(List<Question> currentQuestions) {
        System.out.println(StackOverflowTag.sortByNewest(currentQuestions));
    }
}