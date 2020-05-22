NODE                     EXPLANATION
--------------------------------------------------------------------------------
  \s*                      whitespace (\n, \r, \t, \f, and " ") (0 or
                           more times (matching the most amount
                           possible))
--------------------------------------------------------------------------------
  ;                        ';'
--------------------------------------------------------------------------------
  \s*                      whitespace (\n, \r, \t, \f, and " ") (0 or
                           more times (matching the most amount
                           possible))
--------------------------------------------------------------------------------
  (?=                      look ahead to see if there is:
--------------------------------------------------------------------------------
    (                        group and capture to \1 (0 or more times
                             (matching the most amount possible)):
--------------------------------------------------------------------------------
      [^']*                    any character except: ''' (0 or more
                               times (matching the most amount
                               possible))
--------------------------------------------------------------------------------
      '                        '\''
--------------------------------------------------------------------------------
      [^']*                    any character except: ''' (0 or more
                               times (matching the most amount
                               possible))
--------------------------------------------------------------------------------
      '                        '\''
--------------------------------------------------------------------------------
    )*                       end of \1 (NOTE: because you are using a
                             quantifier on this capture, only the
                             LAST repetition of the captured pattern
                             will be stored in \1)
--------------------------------------------------------------------------------
    [^']*                    any character except: ''' (0 or more
                             times (matching the most amount
                             possible))
--------------------------------------------------------------------------------
    $                        before an optional \n, and the end of
                             the string
--------------------------------------------------------------------------------
  )                        end of look-ahead