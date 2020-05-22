^         # Start of string
\s*       # optional whitespace
\d{2,3}   # match a number (2 to 3 digits)
\s*       # optional whitespace
(?:       # Match...
 \#       # - a hashmark
 \s*      # - optional whitespace
 \d{2,3}  # - a number
 \s*      # - optional whitespace
){2,5}    # 2 to 5 times
$         # End of string