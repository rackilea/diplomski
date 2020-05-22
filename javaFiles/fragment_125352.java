# "(\\s*(\\d*)\\s*,?\\s*((?:\\w*\\s*)+)),?\\s*((?:\\w*\\s*)+)\\s*,?\\s*(\\w{2})?\\s*,?\\s*(\\d{5})?\\s*"

 (                            # (1 start), Adress
      \s* 
      ( \d* )                      # (2), Number
      \s* ,? \s* 
      (                            # (3 start), Street
           (?: \w* \s* )+
      )                            # (3 end)
 )                            # (1 end)
 ,? \s* 
 (                            # (4 start), City
      (?: \w* \s* )+
 )                            # (4 end)
 \s* ,? \s* 
 ( \w{2} )?                   # (5), State
 \s* ,? \s* 
 ( \d{5} )?                   # (6), Zip
 \s*