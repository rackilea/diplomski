public class fooCorporation {
    public float totalPay (double basePay, int hours) {
        if (hours < 0) return -1.0;
        if (hours <= 40) return (float) (basePay * hours);

        int extraHours =  hours - 40;
        float payForFortyHours = (float) (basePay * hours);
        float payForextraHours = (float) (basePay * 1.5 * extraHours);

        return payForFortyHours + payForextraHours;
    }

    public static void main(String[] args){
        fooCorporation foo = new fooCorporation();
        float pay = foo.totalPay (7.50, 35);
        if (pay < 0) System.out.println ("employee 1: invalid hours");
        else         System.out.println ("employee 1: " + pay);

        pay = foo.totalPay (8.20, 47);
        if (pay < 0) System.out.println ("employee 2: invalid hours");
        else         System.out.println ("employee 2: " + pay);

        pay = foo.totalPay (10.00, -4);
        if (pay < 0) System.out.println ("employee 3: invalid hours");
        else         System.out.println ("employee 3: " + pay);
    }
}