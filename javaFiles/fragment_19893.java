grammar Exp;

eval returns [double value]
    :    additionExp
    ;

additionExp returns [double value]
    :    multiplyExp 
         ( '+' multiplyExp 
         | '-' multiplyExp
         )* 
    ;

// ...