public void setSales(double sales) {

    this.sales = sales;
    commission = sales * 0.2;
    compensation = salary + commission;

}

public double getCommission() {

    return commission;

}

public double getCompensation() {

    return compensation;

}