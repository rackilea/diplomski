public class HelloWorld{
    static int[][] multi = new int[][]{
              { 3, 4, 2},
              { 2, 2, 5 },
              { 1, 2 }
    };
    static public void pattern(int row,int multip) {
        if(row >= multi.length) {
            System.out.println(multip);
            return ;
        }
        for(int i = 0; i<multi[row].length;i++) {
            multip*=multi[row][i];
            row+=1;
            pattern(row,multip);
            row-=1;
            multip/=multi[row][i];
        }
    }
    public static void main(String []args){
        pattern(0,1);
    }
}