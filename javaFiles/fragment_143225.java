package carbonfootprinttest;

public class CarbonFootprinttest {
    public static void main(String[] args) {
    building house = new building();
    car fusion = new car();
    bike trek = new bike();
    fusion.getcarbonfootprint();
    double mytest = fusion.returncarbonfootprint();
    System.out.print(mytest);
}