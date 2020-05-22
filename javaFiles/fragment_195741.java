^                     // beginning of string
(                     // begin capturing group #1 (this is actually unnecessary)
  (?=.*\d)            // must contain a digit
  (?=.*[a-z])         // must contain a lowercase letter
  (?=.*[A-Z])         // must contain an uppercase letter
  (?=.*[!@#$%&*])     // must contain a special character
)                     // end capturing group #1
(                     // begin capturing group #2: one character of password, for repetition quantifier
  (.)                 // capturing group #3: one character of password, for negative lookahead
  (?!\3{3})           // character is not followed by itself 3 times
)                     // end capturing group #2
{0,100}               // repeat group #2 up to 100 times
$                     // end of string