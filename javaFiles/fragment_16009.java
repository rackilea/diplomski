public static int[][] hey(){
        int[][] res = new int[10][];

        for(int j=0;j<10;j++){
            int[] v = new int[3];
            for(int i=0;i<3;i++){
                v[i]=i+j;
            }
            res[j]=v;
        }
        return res;
    }