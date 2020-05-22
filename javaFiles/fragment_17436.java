[ :;'?=()!\[\]-]+    any character of: ' ', ':', ';', ''', '?',
                       '=', '(', ')', '!', '\[', '\]', '-' (1 or more times)
 |                   OR
  (?<=               look behind to see if there is:
   \d                digits (0-9)
  )                  end of look-behind
   (?=               look ahead to see if there is:
    \D               non-digits (all but 0-9)
   )                 end of look-ahead