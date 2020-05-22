String str="default string";
    Integer ctr[] = new Integer[32];
    for(int i=0;i<32;i++){
        ctr[i] = new Integer(0);
    }
    for(int i=0;i<str.length() ;i++){

        switch(str.charAt(i)){

        case 0 :
                ctr[0]++;
                break;
        case 1: ctr[1]++;
            break;

        case 2:
                ctr[2]++;
                break;

            //remaining counter 
        case 32:
                ctr[32]++;
                break;
        }
    }