double num1 = 2.0334;  
double num2 = 10.2;
double num3 = 24.0032;

DecimalFormat df1 = new DecimalFormat("#.##");
DecimalFormat df2 = new DecimalFormat("#.#");
DecimalFormat df3 = new DecimalFormat("#");

System.out.print(String.format("%s %s %s", df1.format(num1), df2.format(num2),
        df3.format(num3));