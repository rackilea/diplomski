public static final String checkInput(final String answers) {
    if (answers==null || answers.length() != ANSWER_LENGTH)
        return "ERR!"; // fail fast
    if(!answer.matches("[AB]*")) 
       return "ERR!"; // fail fast
    return "";
}