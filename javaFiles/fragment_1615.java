public static Integer edit(String [] list, Integer listSize){
    Scanner userInput = new Scanner(System.in);
    System.out.print("Enter the row number of the item you would like to edit: ");
    try{
        Integer row = userInput.nextInt();
        if(row <= 0){
            System.out.println("ERROR: The number can't be negative or zero!");
        }
        //check if int is too large
        else if(row > listSize-1){
            System.out.println("ERROR: The number is too big for the list.");
        }
        else{
            /*
            for(int i=row; i<listSize; i++){
                list[i] = list[i+1];
            } 
            */
        }
        System.out.print("Enter name of item: ");
        String name = userInput.nextLine();
        System.out.print("Enter number of items: ");
        String number = userInput.nextLine();
        //list[listSize] = name + ", " + number; 
        list[row] = name + ", " + number; 
    }
    catch(InputMismatchException exception){
        System.out.println("ERROR: You must enter a number to edit an item.");
    }
    return listSize ;
}