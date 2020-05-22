public static void main(String[] args){
    int sum = 0;
    int countOfNumbers = 0;//Tthe same as your change im guessing

    System.out.println("Enter the numbers to find their average type stop to quit: ");//Added stop statement
    Scanner scanner = new Scanner(System.in);//Should be moved out of loop so its not initialized everytime

    while (scanner.hasNext()){//Ensures there is something to check
        String next = scanner.next(); //Pull next Value
        if(next.equalsIgnoreCase("Stop"))//This will prevent looping forever
            break;
        sum = sum + Integer.valueOf(next); //Get total sum
        countOfNumbers++; //Increment total numbers
        System.out.println("The Sum is:"+sum
                +"\nThe count of Numbers averaged is:"+countOfNumbers
                +"\nThe Average is:"+sum/countOfNumbers);//Print info 
    }
    System.out.println("Done Averaging Goodbye");
}