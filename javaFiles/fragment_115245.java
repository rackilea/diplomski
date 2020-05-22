do {
     System.out.print("Enter a number (Enter -1 to exit): "); //prompting the user to enter information
     numb = input.nextDouble();


     if (numb != -1) {
         ab = absolute(numb);
         System.out.printf("The absolute number is %f\n", ab); //prompting the user to enter information

         System.out.println("Enter three numbers"); //prompting the user to enter information
         num1 = input.nextDouble();
         num2 = input.nextDouble();
         num3 = input.nextDouble();

         m = meanNum(num1, num2, num3); // Calling the method Mean Number
         System.out.printf("The Mean Number is: %f\n", m);

         me = medianNum(num1, num2, num3); // Calling the method Median Number
         System.out.printf("The median Number is %f\n", me);
     }
} while (numb != -1);