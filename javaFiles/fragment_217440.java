^                           # Anchors to the beginning to the string.
 (?!                         # Opens NLA
     (?:                     # Opens NCG
         https?              # Literal https
         :                   # Literal :
         \/                  # Literal /
         \/                  # Literal /
     )?                      # Closes NCG
     www                     # Literal www
     \.                      # Literal .
 )                           # Closes NLA
 [a-z0-9]                    # Character class (any of the characters within)
 [a-z0-9-]{0,62}             # Character class (any of the characters within)
 (?:                         # Opens NCG
     \.                      # Literal .
     [a-z0-9]                # Character class (any of the characters within)
     [a-z0-9-]{0,62}         # Character class (any of the characters within)
 )+                          # Closes NCG
 $                           # Anchors to the end to the string.