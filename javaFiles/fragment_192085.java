object // intermediate form 1
    :   ALL* NAME ALL* '{' 
        (   ALL*
        |   (ALL* NAME ALL* NAME)*
        |   (ALL* object)*
        )*
        '}' ALL*
    ;