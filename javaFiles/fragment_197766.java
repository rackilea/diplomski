int getOp(final char c){
    switch(c){
    case OP1_CHAR : return OP1_CODE;
    case OP2_CHAR : return OP2_CODE;
    ...
    default: throw new RuntimeException(c + " is an unknown operation");
    }
}