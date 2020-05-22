private static int recurse(int a, int b) {
    b++;
    if(a==1) return b;
    else if(a%2==0) return recurse((a/2), b);
    else if(a%2==1) return recurse(((a*3)+1), b);
    return b;
}