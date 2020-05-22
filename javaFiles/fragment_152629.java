Scanner sc = new Scanner(System.in);
boolean validInput = false;
int value;
do{
    System.out.println("Please enter an integer");
    try{
        value = Integer.parseInt(sc.nextLine());
        validInput = true;
    }catch(IllegalArgumentException e){
        System.out.println("Invalid value");
    }
}while(!validInput);