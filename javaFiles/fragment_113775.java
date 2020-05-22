public class Bank1 {

private double cash;
private double rate = .0425;
private int years;

public Bank1(double cash, int years){
    this.cash = cash;
    this.years = years;     
}

private double pv1 = cash/Math.pow((1+rate), years);

public double PresentValue(){
    double pv = cash/Math.pow((1+rate), years);
    double present = Math.round(pv *100);
    present = present/100;
    return present;
}


public double  FutureValue(){
    double fv = this.PresentValue()*Math.pow((1+rate), years);
    double future = Math.round(fv *100);
    future = future/100;
    return future;
}   

public static void main(String args[]){
    Bank1 bank = new Bank1(100.0, 1);
    System.out.println("PresentValue: " + bank.PresentValue());
    System.out.println("FutureValue: " + bank.FutureValue());
}

}