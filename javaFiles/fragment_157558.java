capture su var1, meanonly 

if _rc == 0 { 
     local var1_mean = r(mean)
     local var1_min  = r(min)
     local var1_max  = r(max)
}
else display "var1 does not exist"