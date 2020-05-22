class OneProblem {
    public int a = 0;
    public int b = 0;
    public int op = 0;

    public OneProblem(int _a, int _op, int _b) {
        a =_a;
        b = _b;
        op = _op;
    }
}

class MathProblems {

    Vector<OneProblem> problems = new Vector<OneProblem>();

    //...lot of your other code here as well....

    workQuestion(OneProblem problem) {
        switch (problem.op) {
        case 0: 
            add(problem.a, problem.b);
            break;
        case 1: 
            subtract(problem.a, problem.b);
            break;
        case 2:
            multiply(problem.a, problem.b);
            break;
        case 3:
             divide(problem.a, problem.b);
             break;
        }
    }
}