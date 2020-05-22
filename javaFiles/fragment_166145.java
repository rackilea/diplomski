grammar T;

options {
  output=AST;
}

tokens {
  NOT_IN;
  MAP_PAIR;
  MAP;
}

condition_in
 : column_identifier ( 'NOT' 'IN' in_end -> ^(NOT_IN column_identifier in_end)
                     | 'IN' in_end       -> ^('IN' column_identifier in_end)
                     )
 ;

in_end
 : sql_element_list 
 | LPAREN select_stmt RPAREN -> select_stmt
 ;

map
 : '{' (entry (',' entry)*)? '}' -> ^(MAP entry*)

entry
 : k=collection_element ':' v=collection_element -> ^(MAP_PAIR $k $v)
 ;

// ...