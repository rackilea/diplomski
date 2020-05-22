# (?im)^(?=.{1,64}@)(?:("[^"\\]*(?:\\.[^"\\]*)*"@)|((?:[0-9a-z](?:\.(?!\.)|[-!#\$%&'\*\+/=\?\^`\{\}\|~\w])*)?[0-9a-z]@))(?=.{1,255}$)(?:(\[(?:\d{1,3}\.){3}\d{1,3}\])|((?:(?=.{1,63}\.)[0-9a-z][-\w]*[0-9a-z]*\.)+[a-z0-9][\-a-z0-9]{0,22}[a-z0-9])|((?=.{1,63}$)[0-9a-z][-\w]*))$

 # Note - remove all comments '(comments)' before runninig this regex
 # Find  \([^)]*\)  replace with nothing

 (?im)                                     # Case insensitive
 ^                                         # BOS

                                           # Local part
 (?= .{1,64} @ )                           # 64 max chars
 (?:
      (                                         # (1 start), Quoted
           " [^"\\]* 
           (?: \\ . [^"\\]* )*
           "
           @
      )                                         # (1 end)
   |                                          # or, 
      (                                         # (2 start), Non-quoted
           (?:
                [0-9a-z] 
                (?:
                     \.
                     (?! \. )
                  |                                          # or, 
                     [-!#\$%&'\*\+/=\?\^`\{\}\|~\w] 
                )*
           )?
           [0-9a-z] 
           @
      )                                         # (2 end)
 )
                                           # Domain part
 (?= .{1,255} $ )                          # 255 max chars
 (?:
      (                                         # (3 start), IP
           \[
           (?: \d{1,3} \. ){3}
           \d{1,3} \]
      )                                         # (3 end)
   |                                          # or,   
      (                                         # (4 start), Others
           (?:                                       # Labels (63 max chars each)
                (?= .{1,63} \. )
                [0-9a-z] [-\w]* [0-9a-z]* 
                \.
           )+
           [a-z0-9] [\-a-z0-9]{0,22} [a-z0-9] 
      )                                         # (4 end)
   |                                          # or,
      (                                         # (5 start), Localdomain
           (?= .{1,63} $ )
           [0-9a-z] [-\w]* 
      )                                         # (5 end)
 )
 $                                         # EOS