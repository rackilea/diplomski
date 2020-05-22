String exit;
double sum;
do{
    System.out.print("Enter Price here  ");//prompt
    Price = input.nextInt();// 

    System.out.print("Enter Kilograms here  ");//prompt
    Kilograms = input.nextInt();

    System.out.println("Enter "stop" to stop iteration");
    exit = input.next();
    if(exit.equals("stop"){
        sum = Price * Kilograms;
        System.out.printf("Total price is %d\n", sum);
    }
}
while(!exit.equals("stop");