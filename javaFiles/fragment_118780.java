a = a_n;
    b = b_n;
    double a2 ;
    for (int i = 0; i < n; i++) {
        a2 = a * a - b * b + a;    
        b = 2 * a * b + b;
        a=a2;
        ...
    }