String fname;
Scanner scan = new Scanner(System.in);
boolean invalidInput;
do{
    System.out.println("Enter a valid name");
    fname = scan.nextLine();
    invalidInput = fname.matches("[^a-zA-Z'-]]");

    if(invalidInput){
        System.out.println("That's not a valid name");
    }

}while (invalidInput);

System.out.println("Name: " + fname);