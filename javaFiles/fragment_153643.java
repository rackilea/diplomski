/^
  (?:(.)
     (?!\1)           # neighbor characters are not identical
     (?!(?>.*?\1){2}) # character does not occur more than twice
  )*
\z/x