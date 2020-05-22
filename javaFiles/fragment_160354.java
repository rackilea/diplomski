public class Main{
    public static void main(String[] args) {
        int myArr[][] = {
                {1, 1, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0}
        };


        System.out.println(findNumClusters(myArr));
    }

    private static int findNumClusters(int[][] arr){
        int num_clusters = 0;

        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr.length;++j){
                if(arr[i][j] == 1){
                    dfs(arr,i,j,arr.length,arr[0].length);
                    num_clusters++;
                }
            }
        }

        // restore all ones
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr.length;++j){
                if(arr[i][j] == -1) arr[i][j] = 1;
            }
        }

        return num_clusters;
    }

    private static void dfs(int[][] arr,int x,int y,int rows,int cols){
        if(x < 0 || x == rows || y < 0 || y == cols || arr[x][y] != 1) return;
        arr[x][y] = -1; // marking a cell as visited(will be restored later)
        dfs(arr,x-1,y,rows,cols);
        dfs(arr,x+1,y,rows,cols);
        dfs(arr,x,y-1,rows,cols);
        dfs(arr,x,y+1,rows,cols);
    }
}