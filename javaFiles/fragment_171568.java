grammar Test;

options { tokenVocab=TestLexer; }

root : property+;
property  : PROPERTY (ATR EQUALS STRING)+ EOL; // match keyword   property followed by an attribute definition