/    <- Start of the regex
    XXX000    <- Your constant prefix (don't really need to capture it then)
    (         <- Capture the following matching elements
        \w        <- Every characters in [a-zA-Z0-9_]
        {0,60}    <- Between 0 and 60 repetitions of the last element

    )         <- End of the group
/    <- End of the regex