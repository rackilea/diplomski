public interface StackOverflowTag {

    static List<Question> sortByNewest(List<Question> questions) {
        return sortBy("NEWEST", questions);
    }

    static List<Question> sortByVotes(List<Question> questions) {
        return sortBy("VOTE", questions);
    }

    //... other sortBy methods

    private static List<Question> sortBy(String sortByType, List<Question> questions) {
        if (sortByType.equals("VOTE")) {
            // sort by votes
        }
        if (sortByType.equals("NEWEST")) {
            // sort using the created timestamp
        }
        return questions;
    }
}