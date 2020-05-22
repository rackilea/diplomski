public int getSalaryRank() {
        if(yearlySalary <= 60000.00) {
            salaryRank = 1;
        } else  if(yearlySalary <= 80000.00) {
            salaryRank = 2;
        } else if(yearlySalary <= 100000.00) {
            salaryRank = 3;
        } else if(yearlySalary <= 125000.00) {
           salaryRank = 4;
        } else {
           salaryRank = 5;
        }  

        return salaryRank;

    }