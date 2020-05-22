(?<!         # open negative lookbehind
if\s?\(logger\.isLoggable  # look for your if statement
[^\n]{0,20}  # then gobble up a bunch of characters ...
\n           # ... up to the end of the line
\s{0,20}     # optional whitespace at the beginning of the next line
)            # close the look behind
logger\.fine # now, is logger.fine there?