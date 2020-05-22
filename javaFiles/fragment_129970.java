int total=0,counter=0,num; //initialize total and counter to 0

    Scanner scan=new Scanner(new File("myfile.txt")); //scanner to scan integers from file
while(scan.hasNextInt())
{
    if((num=scan.nextInt())>=10 && num <=100) //if num is in range of 10-100
    {
        total+=num; //adding num in each iteration
        counter++;  //increment counter
    }
}

System.out.println(counter+" numbers found in the range 10-100 and their sum is "+total);