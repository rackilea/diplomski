"(         // 1st capture group
   \\w     // Start with a character
 )
 (?:       // Non-capturing group
    ,      // Match `,` after `C`
    \\1    // Backreference to 1st capture group. 
           // Match the same character as in (\\w)
 ){4}"     // Group close. Match 4 times 
           // As 1st one we have already matched in (\\w)