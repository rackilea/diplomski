public double getCompensation() {

    this.compensation = (salary + getCommission());
    return compensation;

}

public String toString() {

    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    return ("Annual Salary: " + fmt.format(salary) + "\n"
                    + "Total Sales: " + fmt.format(sales) + "\n"
                    + "Total Commission: " + fmt.format(getCommission()) + "\n"
                    + "Total Annual Compensation: " + fmt.format(getCompensation()));

}