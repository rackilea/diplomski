public static double medianPay (int p, double[][] salaries)
{
    double median = 0;
    int total = 0;
    int staff = salaries[p].length;

    for (int i = 0; i < staff; i++ )
    {
        total = (int) (total + salaries[p][i]);
        median = total / staff;
    }
    return total;
}