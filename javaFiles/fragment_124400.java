int x = 5;
    switch (x) {
    case 3 : x += 1;
    System.out.println(x);
    case 4 : x += 2;
    System.out.println(x);
    case 5 : x += 3;     /* found a match, so start here.  now x=8  */
    System.out.println(x);
    case 6 : x++;  /* no break statement, so now x=9  */
    System.out.println(x);
    case 7 : x += 2;  /* no break statement, so now x=11  */
    System.out.println(x);
    case 8 : x--;  /* no break statement, so now x=10  */
    System.out.println(x);
    case 9 : x++;  /* no break statement, so now x=11  */
    System.out.println(x);

    }