(?i)           # make the pattern case-insensitive
font-family:
(?>            # open an atomic group
    [^;&\"]++  # all characters except ; & and " one or more times (possessive)
  |            # OR
    &          # literal &
    (?>        # put the different possibilities here
        quot
      |
        ntilde
    )
    ;          # literal ;
)*             # repeat the atomic group zero or more times
(?>
    ;\\s*+     # literal ; and trailing spaces
  |
    (?=\")     # followed by " (last value of the attribute without trailing ; )
)