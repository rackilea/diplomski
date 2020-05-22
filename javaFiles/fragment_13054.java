\$  # match the dollar sign
(  # start group
  \d{1,3}  # match the first (or only) group of 1-3 digits,
  (?:  # start inner group, which we don't capture by itself
    ,  # match a comma
    \d{3}  # followed by three digits
  )*  # 0 or more of the inner group
)  # end expression