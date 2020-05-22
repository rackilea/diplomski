final double principle = 2500.00;
double accrued = 0;
final double interest = 0.075;
int year = 0;
double interest1 = 1.0 + interest;
while (accrued <  5000.00)
{
     year++;
     accrued = principle * Math.pow(interest1, year);
}
System.out.printf("It would take %d years to reach at least $5000 if you start with $2,500 with 7.5%% compound interest.", year);