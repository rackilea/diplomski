(?:[ABCDS][RBGY]|\d{1,2})          match two letter or 1-2 digits
(?:,(?:[ABCDS][RBGY]|\d{1,2})){3}  followed by a comma and another two letters or
                                   1-2 digits, that quantity 3 times
(?:;                               then match semicolon
    (?:[ABCDS][RBGY]|\d{1,2})(?:,(?:[ABCDS][RBGY]|\d{1,2})){3}){3}
                                   followed by the previous pattern 3 more times