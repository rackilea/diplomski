static int apply(int op1, int op2, int operator) {
   switch (operator) {
      case PLUS  : return op1 + op2;
      case MINUS : return op1 - op2;
      case ...
      default: throw new IllegalArgumentException("Unknown operator!");
   }
}