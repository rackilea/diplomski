public int getSalaryRank() {
    int salaryRank;

    if(yearlySalary <= 60000.00) {
        return  1;
    } 

    if(yearlySalary <= 80000.00) {
        return 2;
    } 

    if(yearlySalary <= 100000.00) {
        return 3;
    } 

    if(yearlySalary <= 125000.00) {
       return 4;
    } 

    return 5

}