for (int j = s.nextSetBit(3);j>=0;j=s.nextSetBit(j+1)){
            int k =3 * j;
            while (k <= n){
                s.clear(k);
                k+=j;
            }
        }