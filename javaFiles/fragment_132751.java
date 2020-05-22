WS  :    (' '|'\t')+;
TOKEN   :   (('A'..'Z') | ('a'..'z'))+;
dttok   :   'DT' WS TOKEN;
nntok   :   'NN' WS TOKEN; 
nounPhrase :    (dttok WS nntok);
chunker :  nounPhrase ;