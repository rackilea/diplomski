System.out.print("Number of criteria (Max: 5): ");
int n = Integer.parseInt(inpt.readLine());
System.out.println();
while( n>5 || n<1 ){
    System.out.println("Sorry the maximum limit is 5");
    System.out.println("Please try again");
    System.out.println();

    n = Integer.parseInt(inpt.readLine());
}

double[] arrayCrit = new double[n];
String[] arrayCritName = new String[n];
double check=0;

for (int i = 0; i < n; i++){
    System.out.print("Criteria("+(i+1)+"): ");
    arrayCritName[i] = inpt.readLine();

    if(i == n-1){
        arrayCrit[i] = (100-check)/100;
        System.out.print("Percentage: "+(100-check)+"%");
        continue;
    }

    System.out.print("Percentage: ");

    while(true){
        arrayCrit[i] = Integer.parseInt(inpt.readLine()); 

        if(arrayCrit[i]>100 || arrayCrit[i]<1){
            System.out.println("Sorry, minimum value is 1 and maximum value is 100");
            System.out.println("Please try again");
            System.out.println();
            continue;
        } 

        check=check+arrayCrit[i];  

        if(check>100 || check<1){
            System.out.println("User didn't meet the default percentage (100%)");
            System.out.println(check);
            check=check-arrayCrit[i];
            continue;   
        }

        arrayCrit[i] = arrayCrit[i]/100;
        break;

    }
}