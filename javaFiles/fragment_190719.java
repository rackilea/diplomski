grammar Text;

options {
  output=AST;
}

...

chunk
  :  CHUNK+ -> {new CommonTree(new CommonToken(CHUNK, $text))}
  ;

...