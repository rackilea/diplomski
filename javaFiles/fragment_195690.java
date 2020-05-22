public class HelloWorld{

     public static void main(String []args){
        int row = 9; // row
        int col = 5; // col
        int[][] results = new int[row][col]; // final results
        int[] firstvalues = new int[] {10,100,500,1000,5000};

        for(int a = 0 ; a < firstvalues.length; a++ ) {
            System.out.println(firstvalues[a]);
        }
        //first row to last row
        for(int i = 0;i < row; i++ ) {
            //first column to last column
            for(int j = 0; j < col; j++) {
                if(i==0) {
                    results[i][j] = (firstvalues[j]);
                } 
                    results[i][j] = (i + 1) * firstvalues[j];    
            }
        }

        for(int i = 0; i < row; i++ ) {
            for(int j = 0; j < col; j++) {
                System.out.println("Element at row:" + i + " " + j + " " + results[i][j]);
            }
        }
     }
}