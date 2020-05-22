str.split("(?<!\\\\),");

// OUTPUT: "161544476293", "26220\,1385853403", "WLAN-EneTec5", "-85", "0", "0"


(?<!\\\\) Negative Lookbehind - Assert that it is impossible to match the regex below
\\ matches the character \ literally
, matches the character , literally