void expression(): {} { comparison() (logicalOp() comparison())* }
void logicalOp(): {} { <AND> | <OR> }
void comparison(): {} { simpleExpression() ( comparisonOp() simpleExpression() )? }
void comparisonOp(): {} { <LT> | <GT> | <LE> | <GE> | <EQ> | <NE> }
void simpleExpression(): {} { term() ( addOp() term() )* }
void addOp(): {} { <PLUS> | <MINUS> | <CAT> }
void term(): {} { factor() ( mulOp() factor() )* }
void mulOp(): {} { <MUL> | <DIV> | <MOD> }
void factor(): {} {
    (<PLUS>|<MINUS>) factor()
    | <LPAR> expression() <RPAR>
    | <NOT> expression()
    | <VARIABLE>
    | literalValue()
}