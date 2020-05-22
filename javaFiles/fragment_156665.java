public void getRange() {        
    //System.out.println("\nYou entered: ");
    System.out.print("Enter a Range: ");
    int range = keyboard.nextInt(); 

    System.out.print("array: \n");
    for(int i = 0; i < arr.length; i++){
        int myRnd = (int)( range * Math.random() );

        System.out.print(" " + myRnd + " ");
        arr[i] = myRnd; // <-- You missed this line right here!
    }
}