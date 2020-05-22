public class Invoice
{


  private int inNum;
  private double balDue;
  private int m;
  private int d;
  private int yy;

public Invoice(int inNum, double balDue, int m, int d, int yy) {
    super();
    setInNum(inNum);
    setBalDue(balDue);
    setM(m);
    setD(d);
    setYy(yy);
}


public int getInNum() {
    return inNum;
}




public void setInNum(int inNum) {
    if(inNum < 1000)
        this.inNum = 0;
    else
        this.inNum = inNum;
}




public double getBalDue() {
    return balDue;
}




public void setBalDue(double balDue) {
    this.balDue = balDue;
}




public int getM() {
    return m;
}




public void setM(int m) {
    if(m < 1 || m > 12)
        this.m = 0;
    else
        this.m = m;
}




public int getD() {
    return d;
}




public void setD(int d) {
    if(d < 1 || d > 31)
        this.d = 0;
    else
        this.d = d;

}




public int getYy() {
    return yy;
}




public void setYy(int yy) {
    if(yy < 2011 || yy > 2017)
        this.m = 0;
    else
        this.yy =yy;
}

public static void main(String[] args) {

    Invoice invoice = new Invoice (100, 3000, 14, 29, 2016);
    System.out.println(invoice.getInNum() +" "+ invoice.getBalDue() +" "+ invoice.getM() +" "+ invoice.getD() +" "+ invoice.getYy());


}
}