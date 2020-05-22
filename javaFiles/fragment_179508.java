int a = 10, b = 0;

boolean test  = false && (a / b == 5);  // 1
boolean test2 = (a / b == 5) && false;  // 2

boolean test3 = false & (a / b == 5);   // 3
boolean test4 = (a / b == 5) & false;   // 4