String[] arr = str.split("(?x)/"        +   // Split on `/`
                     "(?="              +   // Followed by
                     "  ("              +   // Start a capture group
                     "     [^\\[\\]]*"  +   // 0 or more non-[, ] character
                     "      \\["        +   // then a `[`
                     "     [^\\]\\[]*"  +   // 0 or more non-[, ] character
                     "     \\]"         +   // then a `]`
                     "  )*"             +   // 0 or more repetition of previous pattern
                     "  [^\\[\\]]*"     +   // 0 or more non-[, ] characters 
                     "$)");                 // till the end