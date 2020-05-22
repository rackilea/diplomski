(?<=[A-Za-z][A-Za-z0-9]*\s*\(\s*) -- Behind:
                                  --   Letter, zero or more letters or digits, parenthesis 

[A-Z0-9]{2,3}                     -- Value to match (2..3 capital letters or digits)

(?=\s*\)                          -- Ahead: 
                                  --   Closing parenthesis