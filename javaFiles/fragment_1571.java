(       // First Capture Group
  \\w   // Any character, before your required sequence. (e.g. `A` in `A,C,C,C,C,C`)
)       // Group end
,       // comma after `A`

(          // Captured group 2
   ^\\1    // Character other than the one in the first captured group. 
           // Since, We now want sequence of `C` after `A`
)
(?:        // non-capturing group
   ,       // Match comma
   \\2     // match the 2nd capture group character. Which is different from `A`, 
           // and same as the one in group 2, may be `C`

){4}       // Match 4 times

(?!        // Negative look-ahead
    ,
    \\2    // for the 2nd captured group, `C`
)