void doOp(final char op){
    switch(c){
    case OP1_CHAR : perform operation 1 which probably requires 
                        popping from the stack, doing some operation,
                        and pushing back onto the stack
        break; // or return;

    case OP2_CHAR : perform operation 2
        break;
    ...
    default: throw new RuntimeException(op + " is an unknown operation");
    }
}