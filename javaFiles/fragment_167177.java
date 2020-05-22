double perc = 0.0;

if( gross_income < 80001 ) 
{
    perc = 0.16; // dont know american tax limits, so lets pretend 0.16
}
else if( gross_income >= 80001 && gross_income < 180001 )
{
    perc = 0.37;
}
else
{
    perc = 0.45;
}
tax_payable = gross_income * perc;

System.out.print("\n\n");... and so on