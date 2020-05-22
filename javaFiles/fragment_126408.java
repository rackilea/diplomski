void moreafternum() : {} {
       "-" ows() <NUM> (sep() body() | <EOF>)
|
       // LOOKAHEAD( <WHITE> ) // Optional lookahead to suppresss the warning
       <WHITE> moreafternum()
|
       ( sep() )? body() }