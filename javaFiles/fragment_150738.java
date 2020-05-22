^                       # Begin of string
    (?=                 # Take a look and make sure if there is
        .*              # Anything zero or more times (greedy)
        \P{ASCII}       # A non-ascii character
    )                   # End of lookahead
    .{6,}               # Match any character 6 or more times
$                       # End of string