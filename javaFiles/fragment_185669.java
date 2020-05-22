private static class QuestionBankRow {

    private static final int QUESTION_INDEX = 0;

    private static final int OPTION_INDEX_START = 1;

    private static final int OPTION_INDEX_END = 4;

    private static final int ANSWER_INDEX = 5;

    private static final int NUM_ELEMENTS_ROW = 6;

    private final List<String> options;

    private final String question;

    private final String answer;

    public QuestionBankRow(String[] rowArr) {
        this.question = rowArr[QUESTION_INDEX];
        this.answer = rowArr[ANSWER_INDEX];
        this.options = new ArrayList<>();
        for (int i = OPTION_INDEX_START; i <= OPTION_INDEX_END; i++) {
            this.options.add(rowArr[i]);
        }
    }

    public String[] getShuffledBankRow() {
        List<String> shuffledOptions = new ArrayList<>(this.options);
        Collections.shuffle(shuffledOptions);
        String[] shuffledRow = new String[NUM_ELEMENTS_ROW];
        shuffledRow[QUESTION_INDEX] = this.question;
        for (int i = OPTION_INDEX_START; i <= OPTION_INDEX_END; i++) {
            shuffledRow[i] = shuffledOptions.get(i - OPTION_INDEX_START);
        }
        shuffledRow[ANSWER_INDEX] = this.answer;
        return shuffledRow;
    }
}