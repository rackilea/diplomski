public TaxReturn(double salary, double deductable, int exempt,
            double creditable)
    {   
        tax = 0;
        income = salary;
        deductions = deductable;
        numberofExemptions = exempt;
        credits = creditable;
        calculateTax();
    }