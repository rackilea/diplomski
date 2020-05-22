if (problems.size()>0) {
    for (int i=0; i<problems.size(); i++) {
        OneProblem selProblem = problems.get(i);
        workQuestion(selProblem);
    }
}
else {
    workQuestion(new OneProblem({{random a}}, {{random op}}, {{random b}}));
}