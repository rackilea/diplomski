public static void printTrue(boolean[] answers, String[] questions) {
    // checking both indices to avoid ArrayIndexOutOfBoundsException
    for (int i = 0; i < answers.length &&  i < questions.length; i++) {
        // if the answer is true
        if (answers[i]) {
            System.out.println(questions[i] + ": " + true);
        }
    }
}