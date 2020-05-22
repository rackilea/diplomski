@Override
public double annualSalary() {
    double dblSalesCommission = 0;
    dblSalesCommission = getAnnualSales() * 0.02;

    if (dblSalesCommission > 20000)
        dblSalesCommission = 20000;

    return (12.0 * getMonthlySalary()) + dblSalesCommission;
}