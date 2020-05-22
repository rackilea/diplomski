date               = date-value

date-value         = date-fullyear date-month date-mday
date-fullyear      = 4DIGIT
date-month         = 2DIGIT        ; 01-12
date-mday          = 2DIGIT        ; 01-28, 01-29, 01-30, 01-31
                                   ; based on month/year