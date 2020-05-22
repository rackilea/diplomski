public static void enumerate(int[] q, int n) {
    for(int a0=0;a0<4;a0++){
        q[0]=a0;
        if(isConsistent(q, 0)){
            for(int a1=0;a1<4;a1++){
                q[1]=a1;
                if(isConsistent(q, 1)){
                    for(int a2=0;a2<4;a2++){
                        q[2]=a2;
                        if(isConsistent(q, 2)){
                            for(int a3=0;a3<4;a3++){
                                q[3]=a3;
                                if(isConsistent(q, 3)){
                                    printQueens(q);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}