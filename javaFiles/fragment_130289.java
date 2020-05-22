^                          - if starts with 
(([\d]),)                  - look for a digit followed by comma and capture the digit 
(?!.*\2)                   - don't allow any other characters or previously matched digits (`\2` matches the previous group which is digits matched in previous step)
(?:(([\d]),)(?!.*\2))       - don't capture the group (capture the entire string)
{0,9}                       - allow only 0-9 occurrences of previous match (9 chars for numbers and 9 chars for commas)
\d$                        - should end with a digit (10th digit)