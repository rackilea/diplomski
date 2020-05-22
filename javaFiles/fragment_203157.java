int years = 1;
while (principal <= goal) {
    double totalInterest = principal * rate * years / 100.0;
    principal = principal + totalInterest;

    System.out.println("Interest amount for year: " + years + 
                       " = " + totalInterest);

    years++;
}

System.out.print("The number of years you must invest to meet your goal of $ ");
System.out.print(goal);
System.out.print(" is");   
System.out.println(years);
System.out.println(" years");