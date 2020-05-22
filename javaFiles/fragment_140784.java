public static void main(String[] args) {double duo_array[][] = {
        {1*0},
        {1*1,1*2},
        {1*3,1*4,1*5},
        {1*6,1*7,1*8},
        {1*9,1*10},
        {1*11}
    } ;
    int i, j = 0;
    //unfinished business
    for(i=0;i<6;i++) {
        for(j=0;j<duo_array[i].length;j++)
            System.out.print(duo_array[i][j] + " ");
            while(j!= 0 ) {
                j--;
    }
//              System.out.println(duo_array[i][j] + " ");
            System.out.println();
        }
}