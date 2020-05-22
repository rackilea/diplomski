public static String rec(String s, int n, int m) {        
    if (n == 0 && m == 0) { 
        return s;
    }
    else {
        if(n > 0) {
            s = s.substring(1);
            n--;
        }
        if(m > 0) {
            s = s.substring(0, s.length()-1);
            m--;
        }
        return rec(s,n,m);
    }
}