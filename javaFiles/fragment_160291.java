^                                          # BOS
 # ASSERTs - Validation
 (?=
      \+                                    # if +, 12 digits
      \D*                      
      (?: \d\D* ){12}
      $ 
   |                                        # or,
      (?= [(\d] )                           # if ( or \d, 10 digits
      \D* 
      (?: \d\D* ){10}
      $ 
 )
 (?! .* -- )                                # optional -, but not 2 in a row

 (?! .* - .* \( .* \) )                     # optional (ddd) but not after -

 (?= [+\d()]* -? [\d()]* -? [\d()]* $ )     # max 2 dashes

 # MATCH
 \+?                                        # optional +
 [-\d]* 
 (?: \( \d{3} \) )?                         # optional (ddd)

 [-\d]*                                     # dash or numbers

 \d                                         # ends with number
 $                                          # EOS