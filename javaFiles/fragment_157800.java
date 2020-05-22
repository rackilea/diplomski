private int[][] reverse(int[][] arr, int n){
        n=n-1;
        int x = n/arr.length;
        int y = n- (x * n) +1;
        for(int i = 0; i< arr.length;i++){
            for(int j = 0; j< arr[i].length; j++){
                if(x==i || y ==j){
                 arr[i][j] = arr[i][j]==0? 1:0;   
                }
            }
        }
        return arr;
    }