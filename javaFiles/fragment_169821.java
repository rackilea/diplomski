STRING_LITERAL
    :  { notDateString() }? 
    ( QUOTE  .*? QUOTE
    | DQUOTE .*? DQUOTE
    )
    ;