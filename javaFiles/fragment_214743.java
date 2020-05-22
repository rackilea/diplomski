public static void main(String[] args) 
{
// Q4. Tax Calculation
Scanner sc= new Scanner(System.in);
System.out.print("Enter your income: ");
double userIncome=sc.nextDouble();

calculateAndPrintTax(userIncome);
}       

static void calculateAndPrintTax(double userIncome)
{
double federalExemption= 11327.0;
double provincialExemption= 9863.0;
double federalTax =  (userIncome- federalExemption) * 0.15;
double provincialTax= (userIncome - provincialExemption) * 0.0505;
double totalTax= federalTax + provincialTax;

System.out.println("Your payable Federal tax is: " + federalTax);
System.out.println("Your payable Provincial tax is: "+ provincialTax);
System.out.println("Total payable tax is: "+ totalTax);
}
}