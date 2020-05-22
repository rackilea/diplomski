int rows = 5;
int cols = 5;
float hostMatrix[] = createExampleMatrix(rows, cols);

System.out.println("Input matrix:");
System.out.println(createString2D(hostMatrix, rows, cols));
float sums[] = new float[rows];
for(int i=0; i<rows; i++){
    float sum = 0,counter=0;
    for(int j=0; j<cols; j++){

        //the problem was here
        if(hostMatrix[i * cols + j] != 0){
            sum += hostMatrix[i * cols + j];
            counter++;
        }
    }
    sum=sum/counter;
    sums[i] = sum;
}

System.out.println("sums of the columns ");
for(int i=0;i<rows;i++){
        System.out.println(" "+sums[i]);
}