for(int i = 997; i>335; i--){
        c = i;
        b = 999-i;
        a = 1;

        while(b>(a+2)){
            b--;
            a++;
            if (isTriplet(a,b,c)){
                product=a*b*c;
                break outerloop;
            }
        }
    }