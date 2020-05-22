for (Question question : test1) {
    boolean passed = True;
    incorrect = 0;
    while (!evaluate(question, scan)) {
        incorrect++;
        if (incorrect == 3) { passed = False; break; }
    }

    if (!passed) { System.out.println("you have failed"); break; }
}