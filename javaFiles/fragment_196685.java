(?<=\b[a-zA-Z']{3}) Positive Lookbehind - Assert that the regex below can be matched
\b assert position at a word boundary
[a-zA-Z']{3} match a single character present, Exactly 3 times
a-z a single character in the range between a and z
A-Z a single character in the range between A and Z
' is literal single quote
[\w']+ matches any word character or single quote [`a-zA-Z0-9_] one or more time