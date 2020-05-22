(?!          // Start negative look-ahead (not followed by)
     .*       // Any string
     (        // Start capture group 1
       [._-]  // Any of ., _, -
     )
     \\1       // \1 (escaped \\1) Same character captured in capture group 1 (avoid consecutive)
 )            // Look-ahead ends
 [A-Za-z]     // Alphabets
 [a-zA-Z._-]  // Any of alphabets, ., -, _
 {4,8}        // repeated 4 to 8 times
 [a-zA-Z]     // ends with alphabet