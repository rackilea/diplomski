...
   System.out.println("Put your weight in pounds");
   weight = sc.nextInt();


   System.out.println("Height: " + feet + " feet, " + inches + " inches");
   System.out.println("Weight: " + weight + " pounds");
   // call corresponding method to calculate:

   convertToInches();
   bmiCalculator();
   weightStatus();
   // now all of those method are executed.

   System.out.println("Your BMI is " + bmi + "category" + status);