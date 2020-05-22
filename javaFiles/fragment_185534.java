public static void generateReport(double sqft,  double gallonCost, int numGallons, double hoursLabor, double paintCost, double laborCost, double totalCost) {
            System.out.print("To paint" + sqft + "square feet, with"); 
            System.out.print("paint that costs" + gallonCost + "per gallon,"); 
            System.out.print("you will need" + numGallons + "gallons of paint"); 
            System.out.print("and" + hoursLabor + "hours of labor."); 
            System.out.print("The cost of the paint is: " + paintCost ); 
            System.out.print("The cost of the labor is: "+ laborCost); 
            System.out.print("The total cost of the job is: " + totalCost); 
            System.out.println();