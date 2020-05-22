//Initialise the array with the values from the file
public static float[][] data(float[][] data, Scanner scan){
    int count = 0; 

    for (int i=0;i<data.length;i++){
        for (int j=0;j<data[0].length;j++){
            count++;    
            if(count<data.length*data[0].length){
                data[i][j] = (float)   IOUtil.skipToDouble(scan); 
                System.out.print(data[i][j] + "  ");
            }    
        }
        System.out.println();
    }
    return data;    
}