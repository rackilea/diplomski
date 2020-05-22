parser grammar testParser;
    options { tokenVocab=testLexer; }

    line    : address encoding opcode condition_code?;
    address : ADDRESS;
    encoding: TOKEN_ENCODING;
    opcode  : TOKEN_OPCODE;
    condition_code : TOKEN_CONDITION_CODE;