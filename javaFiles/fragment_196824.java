public static void qsort(long[] a, int lo, int hi)
    {
        while(lo < hi){
            int  md = lo+(hi-lo)/2;
            int  ll = lo-1;
            int  hh = hi+1;
            long p = a[md];
            long t;
            while(true){
                while(a[++ll] < p);
                while(a[--hh] > p);
                if(ll >= hh)
                    break;
                t     = a[ll];
                a[ll] = a[hh];
                a[hh] = t;
            }
            ll = hh++;
            // only use recursion on smaller partition,
            // then loop back for larger partition
            if((ll - lo) <= (hi - hh)){
                qsort(a, lo, ll);
                lo = hh;
            } else {
                qsort(a, hh, hi);
                hi = ll;
            }
        }
    }