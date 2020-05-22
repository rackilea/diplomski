import java.lang.*;
class MyCalculator{
    public int power(int base, int power){
       if (base < 0 || power < 0){
            throw new Exception("n and p should be non-negative");
       }
            int calculator = (int) Math.pow(base, power);
            return calculator; 
    }
}