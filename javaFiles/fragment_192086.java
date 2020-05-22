object // intermediate form 2
    :   ALL* NAME ALL* '{' 
        (   ALL
        |   ALL* NAME ALL* NAME
        |   ALL* object
        )*
        '}' ALL*
    ;