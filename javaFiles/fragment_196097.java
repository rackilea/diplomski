^              | Enforce beginning of string
(?!\\d+$)      | If 1+ digits at end of string are matched, don't match the following:
(              | Begin group
  ([1-9]\\d*)? |   Optionally match numbers not starting with 0 of any length
  [Dd]?        |   Optionally match either "D" or "d"
  [1-9]\\d*    |   Match numbers not starting with 0 of any length
  ( ?[+-] ?)?  |   Optionally match a "+" or "-" optionally surrounded by spaces
)+             | End group; one or more of these should exist
(?<![+-] ?)    | A "+" or "-" with an optional space shouldn't precede the end
$              | Enforce end of string