public static void main(String [] args){

       DecimalFormat f = new DecimalFormat("$#,##0.00;-$#,##0.00");

       //test with
       long num1 = 9287;
       long num2 = -9287;
       long num3 = 100000000;
       long num4 = 49;

       System.out.println("num1 = "+f.format(num1/100.0));
       System.out.println("num2 = "+f.format(num2/100.0));
       System.out.println("num3 = "+f.format(num3/100.0));
       System.out.println("num4 = "+f.format(num4/100.0));
}