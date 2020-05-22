interface ExceptionalVoidVisitor< E extends Exception > {
    void handleA( A a ) throws E;
    void handleB( B b ) throws E;
}
interface VoidVisitor extends ExceptionalVoidVisitor< RuntimeException > {}
interface ExceptionalVisitor< T, E extends Exception > {
    T handleA( A a ) throws E;
    T handleB( B b ) throws E;
}
interface Visitor< T > extends ExceptionalVisitor< T, RuntimeException > {}