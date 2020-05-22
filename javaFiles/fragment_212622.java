double[] grade = new double[10];
double sum=0, average=0;

for(int row=0; row<10; row++) {
    sum = 0;
    for(int col=0; col<scores[row].length; col++){
        sum += scores[row][col];
    }
    average = sum/5;
    grade[row] = average;
}