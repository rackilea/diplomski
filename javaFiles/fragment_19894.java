grammar Exp;

/* This will be the entry point of our parser. */
eval returns [double value]                                                  
    :    additionExp { /* plain code block! */ System.out.println("value equals: "+$value); }
    ;

// ...