object // final form
    :   ALL* NAME ALL* '{' 
        (   ALL
        |   NAME ALL* NAME
        |   object
        )*
        '}' ALL*
    ;