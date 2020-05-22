int a = 0;
int b = 1;
int c = 0;

while (true) {
    c = a + b;  // `a + b = c` isn't valid, so you have to flip it around.
    a = b;      // `b` "becomes" `a`
    b = c;      // `c` "becomes" `b`
    c = a;      //  You don't need this step because `c` is just a temp variable
}