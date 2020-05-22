return a * a;
} /* if (p % 2 == 0) */ else {
    /*
     * Statements are unnecessarily nested within else clause.
     * The corresponding then clause does not complete normally.
     * Moving the following code snippet out of an else block
     * would have the same effect, but simplifies the control
     * statements.
     */
    int a = pow(x, ((p - 1) / 2));
    return x * a * a;
}