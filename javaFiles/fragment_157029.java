^             # Start of string
(?=.*([1-9])) # Assert that there is at least one digit > 0, capture that digit
\d{2}         # Match any two digits
-?            # Match an optional hyphen
\d{7}         # Match any seven digits
$             # End of string