for (int i = 0; i < test1.size(); i++) {
    Question question = test1.get(i);
    if (evaluate(question, scan)) {
        ...
    } else {
        incorrect++;
        i--;
    }

    if (incorrect == 3) { ... }
}