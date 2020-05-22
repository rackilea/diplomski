// In the language this comes from, statements are *always* followed by
// a semicolon. Most languages don't work that way, though.
statement_list ::= statement_list statement T_SEMICOLON |
                   // EMPTY
                   ;

// Parameter lists (and argument lists) are either empty or have the items
// *separated* by commas. Because the comma is only present if there are at
// least two items, we need to special-case the empty list:

parameter_list ::= T_OPAREN T_CPAREN |
                   T_OPAREN parameters T_CPAREN
                   ;
parameters     ::= parameter |
                   parameters T_COMMA parameter
                   ;