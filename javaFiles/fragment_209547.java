Scanner scan = new Scanner(System.in);


String allNums = "";


for(int i =0; i<6; i++) 
{
    System.out.println("Enter your number between 1-59");
    int num = scan.nextInt();//Take the number in as an int 

    if(num >0 && num < 59)//Check if it is in range
    {
        allNums += num + " ";//if it is add it to a string
    }
    else
    {
        System.out.println("Number not in range");
        i--;//go back one iteration if its not in range
    }


}

System.out.println("Ticket printed £2. Your numbers are " + allNums);