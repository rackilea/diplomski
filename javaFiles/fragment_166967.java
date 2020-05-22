enum Operator {
    PLUS  { int apply(int op1, int op2) { return op1 + op2; } },
    MINUS { int apply(int op1, int op2) { return op1 - op2; } },
    ...
    ;
    abstract int apply(int op1, int op2);
}