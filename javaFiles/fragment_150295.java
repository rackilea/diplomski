int a1 = a;
    int b2 = b;
    int a3 = a;
    a = a3 ^ b;
    b = b2 ^ a;
    a = a1 ^ b;