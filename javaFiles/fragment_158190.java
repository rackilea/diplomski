double[] sum = new double[marks.length];

for(row = 0; row < marks.length; row++)
{                                          //ROW,COL
    double score1 = Double.parseDouble(marks[row][2]);  //parsing the data from the array into a double
    double score2 = Double.parseDouble(marks[row][3]);
    double score3 = Double.parseDouble(marks[row][4]);
    double score4 = Double.parseDouble(marks[row][5]);

    sum[row] = score1*0.1 + score2*0.4 + score3*0.2 + score4*0.3;   
    average += sum[row];
}
average = average/sum.length; //1
for(row = 0; row < sum.length; row++)
{
        mean += Math.pow(Math.abs(sum[row] - average),2);           
}
mean = mean/marks.length;//2
stdDev = Math.sqrt(mean);