public static float[][] data(float[][] data, Scanner scan){
    for (int i=0;i<data.length;i++){
        for (int j=0;j<2;j++){
            data[i][j] = (float)   IOUtil.skipToDouble(scan); 
            System.out.print(data[i][j] + "  ");
        }
        System.out.println();
    }
    return data;    
}