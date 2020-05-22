-- I added number here in order to be explicit.
atom       ::= identifier | number | "null" | "(" expression ")"
-- I added function calls here, but it's arguable that this syntax accepts
-- a lot of invalid expressions
primary    ::= atom { "++" | "--" | "(" [ arglist ] ")" }
factor     ::= [ "-" | "++" | "--" ] primary
term       ::= factor { ( "*" | "/" | "%" ) factor }
value      ::= term { ( "+" | "-" ) term }
-- This adds the ordinary "=" assignment to the list in case it was
-- omitted by accident. Also, see the note below.
expression ::= { value ( "=" | "+#" | "-=" | "*=" | "/=" | "%=" ) } value
arglist    ::= expression { "," expression }