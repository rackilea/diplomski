public CommissionEmployee(String firstName, String lastName, 
String socialSecurityNumber, double grossSales, 
double commissionRate)
{
  super(firstName, lastName, socialSecuityNumber);  
  this.grossSales = grossSales;
  this.commissionRate = commissionRate;
}