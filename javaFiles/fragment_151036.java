public static somethingA(int n) {
    // do something
    if(n == x)
       MC.methodA();
}

public static somethingB(int n) {
    // do something
    if(n == y)
        MC.methodB();
}

// is this a compile error or not
for(int i=0;i<10;i++) {
    somethingB(i);
    somethingA(i);
}