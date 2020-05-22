public void binaryOperation(Operand op1, Operand op2) {
      synchronized (op1) {
          synchronized (op2) {
               // do something that needs the locks
          }
      }
  }

  // now call passing the same object for both operands
  Operand op = ...
  binaryOperation(op, op);