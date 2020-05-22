public static void main(String[] args){

    Scanner scanner = new Scanner(System.in);

    String strings[]= new String[3];

    for(int i=0; i<3; i++) //do 3 times
    {
        System.out.println("Enter string: ");

        //get user input
        String input = scanner.nextLine();
        strings[i] = input;

        //check if input is correct size
        if(input.length()!=3){
            System.out.println("Error: input is wrong size; must be size 3");
        }

        //check that the input only consists of 'a' and 'b' characters
        for(int j=0;j<input.length();j++){
            if(input.charAt(j) !='a' && input.charAt(j) != 'b'){
                System.out.println("Error: input contains invalid characters");
                break; //after finding an invalid character, break out of inner loop
            }
        }
    }
    scanner.close(); //close the scanner after it is no longer needed

    System.out.println("You entered the following strings: ");

    for (int i = 0; i < 3; i++) {
        System.out.println(strings[i]);
    }
}