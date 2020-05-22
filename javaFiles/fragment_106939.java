grammar ::= [{ assignment }] eoi
assignment ::= name ('::=' | '=') expression
expression = term [{ '|' term }]
term = factor [{ white factor }]
factor = IO | name | '[' expression ']' | '&{' expression '&}'
IO = '\'' string '\'' | '"' string '"' | '`' string '`'