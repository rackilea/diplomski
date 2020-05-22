Scanner in= new Scanner(System.in);
System.out.println("How many number?")
int numberAmount = Integer.parseInt(in.nextLine());
int sum=0;
int average=0;

for(count=1;count<=numberAmount;count++){
    System.out.println("Number"+count+" :");
    sum+=Integer.parseInt(in.nextLine());
}

average = sum / numberAmount;
System.out.println("The average of " +numberAmount+" entered number(s) is "+average);