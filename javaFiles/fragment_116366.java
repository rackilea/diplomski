private double computeGrossPay()
{
    double grossPay; //declare the local variable

    //assign it depending on hoursWorked
    if (hoursWorked <= 40)
    {
        grossPay = (hoursWorked * payRate);
    }
    else
    {
        grossPay = ((40 * payRate) + ((1.5 * payRate) * (hoursWorked - 40)));
    }

    //return its value
    return grossPay;
}