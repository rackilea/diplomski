// ignore everything around this
try {
    // nothing in this block 
    // can throw a TestException

    throw new ArithmeticException();

// this whole catch block is useless code
// Test Exception can never be thrown
} catch (final TestException e){ 
    throw e;
} 
// ignore everything around this