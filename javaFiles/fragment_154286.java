class SalesPreInt
{   
    public static void main(String[] args)

        {
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many employees are we looking at?");
        int noOfReps = userInput.nextInt();

        userInput.close();

        EmpSales[] employees = new EmpSales[noOfReps];


        for(int i = 0; i< noOfReps; i ++){
            //Name empName = new Name(); //Don't make a Name variable
            String empName = empName(); //Make a String variable to hold the name instead

            //Calc totalComp = new Calc(); //Don't make a Calc variable
            BigDecimal totalComp = totalComp(); //Make a BigDecimal variable instead
            employees[i] = new EmpSales(empName,totalComp); //Should work now that the above are of the correct type

//The error below was because you were passing a (Name, Calc) variables to a constructor that only took (String, BigDecimal) parameters.
// The constructor EmpSales(Name, Calc) is undefined


        }//missing close bracket for for loop here
    }//missing close bracket for main method here

//Empsales class moved to bottom so it can be outside SalesPreInt class

//class Pay { //remove this class, you only need the method

    public static BigDecimal basePay() {
        int basePay = 50000;
        return new BigDecimal(String.valueOf(basePay));
    }
//}

//class Calc { //remove this class, you only need the method

    public static BigDecimal totalComp(){
        //Pay pay = new Pay(); //Don't create a Pay variable
        //pay.basePay();

        BigDecimal intCalc = new BigDecimal("0.15");

        Scanner userInput = new Scanner(System.in);

        System.out.println("What were your total sales?");
        BigDecimal salesPre = userInput.nextBigDecimal();
        System.out.println("You're Total Sales were "+salesPre);

        userInput.close();

        BigDecimal postIntCalc = salesPre.multiply(intCalc);
        BigDecimal totalComp = postIntCalc.add(basePay()); //Just use the basePay() method instead

        System.out.println("Your total sales including commission is "+postIntCalc);
        System.out.println("Your total pay is"+totalComp);

        return new BigDecimal(String.valueOf(totalComp()));
    }
//}

//class Name { //Don't use this class, just the method inside
    public static String empName(){

        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the Sales Rep Name?");
        String empName = userInput.toString();

        userInput.close();

        return empName;
    }
//}


/*    }
 }


}*/ //extra brackets not needed
}//close bracket for SalesPreInt class here

class EmpSales{ //This looks ok, could be in another file, but since it's a helper class, looks fine here
    String empName; 
    BigDecimal totalComp;            
    public EmpSales(String empName, BigDecimal totalComp){ 
        this.empName = empName; 
        this.totalComp = totalComp; 
        //Initializing stuff
    }

}//missing close bracket for Empsales here