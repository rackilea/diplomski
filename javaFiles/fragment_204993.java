/* causes a compilation error because
   MathOperation is not a functional interface */
@FunctionalInterface
interface MathOperation {
    int operation1(int a, int b);
    int operation2(int c, int d, int e);
}