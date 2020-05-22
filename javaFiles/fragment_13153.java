# begin regex:
(               # start group
    ^           # find the beginning of input,
    |           # or
    [^\\]       # one character which is not the backslash
)               # end group
                # followed by
(               # start group
    \\{2}       # exactly two backslashes
)               # end group
*               # zero or more times
                # and at that position,
(?=             # begin lookahead
    \$          # find a $
)               # end lookahead
                # end regex