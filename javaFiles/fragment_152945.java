public class AnnualCompensationCalculator{
    private static double commissionPercentage = 0.06;
        public static double calculateCompensation(double sales ,double salary){
             return((sales * commissionPercentage) + salary);
        }
    }