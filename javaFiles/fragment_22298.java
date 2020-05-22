public double salaryTax(double salary) {

    double taxRate = 0.15;

    if (salary >= 45000) {
         taxRate = 0.5;

    }
    else if (salary >= 30000) {
        taxRate = 0.3;
    }

    return  salary*(1.0- taxRate);
}