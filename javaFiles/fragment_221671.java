^            # Start of string
(?:          # Start of non-capturing group:
 0(?![901])| # Match 0, unless followed by 9, 0, or 1
 1(?![0-2])| # etc...
 2(?![1-3])|
 3(?![2-4])|
 4(?![3-5])|
 5(?![4-6])|
 6(?![5-7])|
 7(?![6-8])|
 8(?![7-9])|
 9(?![890])
){6}         # 6 times
$            # End of string