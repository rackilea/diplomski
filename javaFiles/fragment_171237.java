int x ;
//check if x is a multiple of any two factors < x
for (int i1 = 2 ; i1 < x ; i1++) {
    for (int i2 = i1 ; i2 < x ; i2++) {
        prod = i1 * i2 ;
        if (prod > x) break ;
        if (prod == x) return "x is not prime" ;
    }
}
return "x is prime" ;