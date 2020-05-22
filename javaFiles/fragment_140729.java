private Question pickQuestion() {
    if (availableQuestions == 0) { // Takes care of initialisation too.
        availableQuestions = quesList.size();
    }
    int qid = random.nextInt(availableQuestions);
    Question q = quesList.get(qid);

    // Switch question with the last one, and have one less available:
    --availableQuestions;
    quesList.put(qid, quesList.get(availableQuestions));
    quesList.put(availableQuestions, q);
    return q;
}