import java.util.Random;
    public class Server{
    private static int[][] table;
    public static int[][] tableMaker(){
            table = new int[5][5];
            for(int i=0; i<table.length; i++){
                for(int j=0; j<table.length; j++){
                    if(i==2 && j==2){
                        table[i][j] =3;
                    }
                    else if(i==0 || i==4){
                        table[i][j] = 1;
                    }
                    else if(j==4 || j==0){
                        table[i][j] = 1;
                    }
                    else if((i==1 || i==3) && (j>0 || j<4)){
                        table[i][j] = 2;
                    }
                    else if((i==2 && j==1) || (i==2 && j==3)){
                        table[i][j] = 2;
                    }
                }
            }
            return table;
        }

        public static void printTable(){
            for(int i=0; i<table.length; i++){
                for(int j=0; j<table.length; j++){
                     if(table[i][j] == -1) System.out.print("P ");
                     else System.out.print(table[i][j] + " "); 
                }
                System.out.println();
            }
        }



        public static int[][] tossPenny(){
            Random row = new Random();
            Random column = new Random();
            for(int i=0; i<5; i++){
                table[row.nextInt(4)][column.nextInt(4)] = -1;
            }
            return table;
        }

    }