"([A-Z]\([a-z]=\d+(?:,[a-z]=\d+)*\);)+"

/(
 [A-Z] # An uppercase character
 \(    # A literal "("
 [a-z] # A lowercase character
 =     # A literal "="
 \d+   # Some digits
  (?:,[a-z]=\d+)* # Optional repeat groups
 \);   # Literal character sequence ");"
)+     # One or more
 /x