boolean expr1, expr2;

if (expr1 = (x == 5) | expr2 = (x == 2)) {  
    // huge block of code that happens
    if (expr1) five();
    if (expr2) two();
}