String fname;
Scanner scan = new Scanner(System.in);
boolean invalidInput;
Pattern pattern = Pattern.compile("[^a-zA-Z'\\-\\s]");

do{
    System.out.println("Enter a valid name");
    fname = scan.nextLine();
    invalidInput = pattern.matcher(fname).find();

    if(invalidInput){
        System.out.println("That's not a valid name");
    }
}while (invalidInput);

System.out.println("Name: " + fname);