public class Employee {
  public final String name;
  public final double rate;
  public final double hours;
  public final double weeklypay;

  public Employee(String name, double rate, double hours) {
    this.name = name;
    this.rate = rate;
    this.hours = hours;
    this.weeklypay = this.rate*this.hours;
  }

  public String toString() {
    return name+"'s pay:" + weeklypay;
  }
}