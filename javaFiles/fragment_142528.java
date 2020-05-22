lexer grammar testLexer;

    tokens {WHITE_SPACE, TOKEN_OPCODE, TOKEN_ADDRESS, TOKEN_ENCODING, TOKEN_CONDITION_CODE}

    ADDRESS         : [a-fA-F0-9]+ -> type(TOKEN_ADDRESS);
    WS              : [ \t]+ -> type(WHITE_SPACE), skip, pushMode(ENCODE);
    NEWLINE         : [\r\n]+ -> type(WHITE_SPACE), skip;

    mode ENCODE; 
    ENCODING        : [a-fA-F0-9]+ -> type(TOKEN_ENCODING);
    ENC_WS          : [ \t]+ -> type(WHITE_SPACE), skip, popMode, pushMode(OPCODES);

    mode OPCODES;
    OP_WS       : [ \t]+ -> type(WHITE_SPACE), popMode;
    ALL_ADD     : (ADD | ADDS) -> popMode, pushMode(CONDITION_CODES), type(TOKEN_OPCODE) ;
    ADD         : 'add';
    ADDS        : 'adds';

    mode CONDITION_CODES;
    CONDITION_CODE   : 'eq' -> type(TOKEN_CONDITION_CODE);
    WS_COND          : [ \t]+ -> type(WHITE_SPACE), skip, popMode;