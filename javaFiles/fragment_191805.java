//Only print X
public static void printX(float[][] data){

    for (int i=0;i<data.length;i++){
       System.out.println(data[i][0]);
    }
}

//Only print Y
public static void printY(float[][] data){
    for (int i=0;i<data.length;i++){
       System.out.println(data[i][1]);
    }
}

//Print both
public static void printBoth(float[][] data){
    for (int i=0;i<data.length;i++){
       System.out.println(data[i][0] + ", " + data[i][1]);
    }
}


//Print any number in array:
public static void printAll(float[][] data){
    for (int i=0;i<data.length;i++){
        for (int j=0;j<data[i].length;j++){
            System.out.print(data[i][j];
            if (j+1 < data[i].length) {
                System.out.print(", ");
            } else {
                System.out.println();
            }
        }
    }
}