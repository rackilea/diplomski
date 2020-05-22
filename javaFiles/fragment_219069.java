while(w && j < ar1[i].length) {
        if(ar1[i].charAt(j)=='+' || ar1[i].charAt(j)=='-' || ar1[i].charAt(j)=='*' || ar1[i].charAt(j)=='/') {
            w=false;
        }
        else {
            k=ar1[i].charAt(j);
            a=a*10+ (long)(k-48);
        }
        j++;
    }