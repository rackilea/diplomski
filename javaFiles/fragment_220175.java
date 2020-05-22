static double[] hoursArray(double[][] weeklyhours)
{
    double[] sum=new double[weeklyhours.length]
    for(int row=0;row < sum.length;row++)
    {
        for(int i=0;i<weeklyhours[row].length;i++)
            sum[row]+=weeklyhours[row][i]
    }
    return sum;
}