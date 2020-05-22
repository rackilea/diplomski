^ assert position at start of a line
https: matches the characters https: literally (case insensitive)
\/ matches the character / literally
\/ matches the character / literally
[a-z]{2,3} match a single character present in the list below

    Quantifier: {2,3} Between 2 and 3 times, as many times as possible, giving back as needed [greedy]
    a-z a single character in the range between a and z (case insensitive)

\. matches the character . literally
linkedin matches the characters linkedin literally (case insensitive)
\. matches the character . literally
com matches the characters com literally (case insensitive)
\/ matches the character / literally
.* matches any character (except newline)

    Quantifier: * Between zero and unlimited times, as many times as possible, giving back as needed [greedy]

$ assert position at end of a line