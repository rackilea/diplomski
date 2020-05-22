class MyClass {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        int[][] sampleArray = {{11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22},
                {23, 24, 25, 26, 27, 28},
                {29, 30, 31, 32, 33, 34},
        };

        myClass.removeEdges(sampleArray);
    }


    public int[][] removeEdges(int[][] arrayToTrim){
        int[][] newArray = new int[arrayToTrim.length-2][arrayToTrim[0].length-2];
        print2DArray(arrayToTrim);
        for(int i=1;i<arrayToTrim.length-1;i++){
            for(int j=1;j<arrayToTrim[0].length-1;j++){
                newArray[i-1][j-1] = arrayToTrim[i][j];
            }
        }
        System.out.println();
        print2DArray(newArray);
        return newArray;
    }

    private void print2DArray(int[][] anArray){
        for(int i=0;i<anArray.length;i++){
            System.out.println();
            for(int j=0;j<anArray[0].length;j++){
                System.out.print(anArray[i][j]+" ");
            }
        }
    }
}