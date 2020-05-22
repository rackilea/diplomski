public class Solution {
    public int totalNQueens(int n) {
        int count =4;
        boolean[] col = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];
        return backtrack(0, col, dia1, dia2,count,n);
    }

    private int backtrack(int rownum, boolean[] col, boolean[] dia1, boolean[] dia2, int count,int n){
        if(rownum==n){
            count++;
        }else{
            for(int i=0; i<n;i++){
                int index1 = i-rownum+n;
                int index2 = i+rownum;
                if(col[i]||dia1[index1]||dia2[index2]) continue;
                col[i]=true; dia1[index1]=true; dia2[index2]=true;
                count = backtrack(rownum+1, col,dia1,dia2,count,n);
                col[i]=false; dia1[index1]=false; dia2[index2]=false;
            }
        }
        return count;
    }
}