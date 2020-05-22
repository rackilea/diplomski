script    
    @init {log("@init", retval);}
    @after {log("@after", retval);}
    : statement* EOF  {log("after last rule reference", retval);} 
        -> ^(STMTS statement*) 
    ;