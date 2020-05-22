\$      # match a literal $
\{      # match a literal {
(       # start capturing group 1
  [^}]  # match any single character except } - note the negation by ^
  +     # repeat one or more times
)       # end of capturing group 1
\}      # match a literal }