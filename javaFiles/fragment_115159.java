public static double inputTotalSales(){
    Scanner keyboard = new Scanner(System.in);      
    out.println("Enter the total sales for this month.");
    double  inputTotalMonthlySales = keyboard.nextDouble(); 
    return inputTotalMonthlySales;
}