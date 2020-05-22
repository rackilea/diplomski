^                        # the beginning of the string
\d+                      # digits (0-9) (1 or more times (matching
                         # the most amount possible))
(?:                      # group, but do not capture (0 or more times
                         # (matching the most amount possible)):
  ,                      #   ','
  \d{3}                  #   digits (0-9) (3 times)
)*                       # end of grouping
(?:                      # group, but do not capture (optional
                         # (matching the most amount possible)):
  \.                     #   '.'
  \d{3}                  #   digits (0-9) (3 times)
)?                       # end of grouping
$                        # before an optional \n, and the end of the
                         # string