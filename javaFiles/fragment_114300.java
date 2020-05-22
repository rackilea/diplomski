public class SpiralMatrix {
    public static void main (String args[]){
        int[][] mat = { {1, 2,  3,  4,  5},
                        {6, 7,  8,  9,  10},
                        {11,12, 13, 14, 15}};
        int i,n=3,m=5,r=m-1,q=n-1;
        while(q>0 && r>0){
            for(i=m-1-r;i<=r;i++){
                System.out.println(mat[m-1-r][i]);
            }
            for(i=n-1-q+1;i<=q;i++){
                System.out.println(mat[i][r]);
            }
            for(i=r-1;i>=m-1-r && q>1;i--){
                System.out.println(mat[q][i]);
            }
            for(i=q-1;i>=n-1-q+1 && r>1;i--){
                System.out.println(mat[i][n-1-q]);
            }
            q--;
            r--;
        }
    }
}