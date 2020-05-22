static int hacko(int n) {

    if(n < 4)
        return n;
    else
        return hacko(n-1)+(2*hacko(n-2))+(3*hacko(n-3));

}